package com.fanglin.service.impl;

import com.fanglin.annotation.LocalCache;
import com.fanglin.core.others.Assert;
import com.fanglin.core.page.Page;
import com.fanglin.core.page.PageResult;
import com.fanglin.core.token.TokenInfo;
import com.fanglin.entity.user.ShopCarEntity;
import com.fanglin.entity.user.UserEntity;
import com.fanglin.mapper.MapperFactory;
import com.fanglin.model.user.HotSearchModel;
import com.fanglin.model.user.ShopCarModel;
import com.fanglin.model.user.UserModel;
import com.fanglin.service.UserService;
import com.fanglin.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * 用户服务实现类
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    MapperFactory mapperFactory;

    @Override
    public List<HotSearchModel> userSearchHistoryList(Integer userId) {
        return mapperFactory.hotSearchMapper.userSearchHistoryList(userId);
    }

    @Override
    @LocalCache(value = "hot_search",timeout = 1,unit = TimeUnit.HOURS)
    public List<HotSearchModel> hostSearchList() {
        return mapperFactory.hotSearchMapper.hostSearchList();
    }

    @Override
    public UserModel userLogin(HttpServletRequest request, HttpServletResponse response, String account, String password) {
        Assert.notEmpty(account,"请输入账号");
        Assert.notEmpty(password,"请输入密码");
        Assert.isTrue(RegexUtils.checkPhone(account),"手机号格式错误");
        Assert.isTrue(password.length()<=30,"密码最多30位");
        UserEntity user = mapperFactory.userMapper.selectOne(new UserEntity().setAccount(account));
        Assert.notNull(user,"用户不存在");
        Assert.isTrue("0".equals(user.getIsDisable()),"账号已冻结");
        Assert.isTrue(EncodeUtils.md5Encode(password).equals(user.getPassword()),"密码错误");
        TokenInfo tokenInfo = TokenUtils.login(response,new TokenInfo().setId(user.getId()));
        return BeanUtils.copy(user,UserModel.class).setPassword(null).setPayPassword(null);
    }

    @Override
    public PageResult<ShopCarModel> shopCarList(Integer userId, Page page) {
        return new PageResult<>(mapperFactory.shopCarMapper.shopCarList(userId,page),page.getTotal());
    }

    @Override
    public int insertShopCart(ShopCarModel shopCarModel) {
        return mapperFactory.shopCarMapper.insertSelective(BeanUtils.copy(shopCarModel, ShopCarEntity.class));
    }

    @Override
    public int deleteShopCarByIds(Integer userId, String ids) {
        return mapperFactory.shopCarMapper.deleteShopCarByIds(userId,ids);
    }
}
