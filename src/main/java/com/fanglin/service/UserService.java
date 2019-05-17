package com.fanglin.service;


import com.fanglin.core.page.Page;
import com.fanglin.core.page.PageResult;
import com.fanglin.model.user.HotSearchModel;
import com.fanglin.model.user.ShopCarModel;
import com.fanglin.model.user.UserModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用户服务
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface UserService {

    /**
     * 搜索记录
     * @param userId
     * @return
     */
    List<HotSearchModel> userSearchHistoryList(Integer userId);

    /**
     * 搜索记录
     * @param id
     * @return
     */
    List<HotSearchModel> hostSearchList();

    /**
     * 用户登录
     * @param request
     * @param response
     * @param account
     * @param password
     * @return
     */
    UserModel userLogin(HttpServletRequest request, HttpServletResponse response, String account, String password);

    /**
     * 购物车列表
     * @param userId
     * @param page
     * @return
     */
    PageResult<ShopCarModel> shopCarList(Integer userId, Page page);

    /**
     * 添加购物车记录
     * @param shopCarModel
     * @return
     */
    int insertShopCart(ShopCarModel shopCarModel);

    /**
     * 批量删除购物车
     * @param userId 用户id
     * @param ids 购物车id，逗号分隔
     * @return
     */
    int deleteShopCarByIds(Integer userId, String ids);
}
