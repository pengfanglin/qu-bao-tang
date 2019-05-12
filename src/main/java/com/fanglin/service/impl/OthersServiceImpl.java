package com.fanglin.service.impl;

import com.fanglin.annotation.LocalCache;
import com.fanglin.entity.others.CodeEntity;
import com.fanglin.mapper.MapperFactory;
import com.fanglin.model.banner.HomeBannerModel;
import com.fanglin.service.OthersService;
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
     * @param code
     * @return
     */
    @Override
    public int insertCode(CodeEntity code) {
        return mapperFactory.codeMapper.insertSelective(code.setCreateTime(new Date()));
    }

    @Override
    @LocalCache(value = "home_banner",timeout = 1,unit = TimeUnit.DAYS)
    public List<HomeBannerModel> homeBannerList() {
        return mapperFactory.bannerMapper.homeBannerList();
    }

}
