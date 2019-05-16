package com.fanglin.service.impl;

import com.fanglin.annotation.LocalCache;
import com.fanglin.core.others.Ajax;
import com.fanglin.core.others.Assert;
import com.fanglin.enums.others.CodeType;
import com.fanglin.mapper.MapperFactory;
import com.fanglin.model.banner.HomeBannerModel;
import com.fanglin.model.others.CodeModel;
import com.fanglin.service.OthersService;
import com.fanglin.utils.OthersUtils;
import com.fanglin.utils.SmsUtils;
import com.fanglin.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 其他服务实现类
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@Service
public class OthersServiceImpl implements OthersService {

    @Autowired
    MapperFactory mapperFactory;

    /**
     * 添加新的验证码
     *
     * @return
     */
    @Override
    public void sendCode(CodeModel codeModel) {
        CodeType codeType=CodeType.find(codeModel.getType());
        Assert.notNull(codeType,"验证码类型不存在");
        codeModel.setCode(OthersUtils.createRandom(4));
        Assert.isTrue(SmsUtils.zhuTong(codeModel),"验证码发送失败");
    }

    @Override
    @LocalCache(value = "home_banner",timeout = 1,unit = TimeUnit.DAYS)
    public List<HomeBannerModel> homeBannerList() {
        return mapperFactory.bannerMapper.homeBannerList();
    }

}
