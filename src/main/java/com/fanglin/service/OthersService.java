package com.fanglin.service;

import com.fanglin.model.banner.HomeBannerModel;
import com.fanglin.model.others.CodeModel;

import java.util.List;


/**
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface OthersService {

    /**
     * 首页轮播图
     * @return
     */
    List<HomeBannerModel> homeBannerList();

    /**
     * 添加新的验证码
     * @param setKey
     */
    void sendCode(CodeModel codeModel);
}
