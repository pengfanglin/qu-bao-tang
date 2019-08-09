package com.fanglin.controller;

import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.core.others.Wx;
import com.fanglin.common.utils.UploadUtils;
import com.fanglin.common.utils.WxUtils;
import com.fanglin.enums.others.CodeType;
import com.fanglin.model.banner.HomeBannerModel;
import com.fanglin.service.OthersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 其他接口控制器
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
@RestController
@RequestMapping("/others/")
@Api(value = "/others/", tags = {"其他"})
public class OthersController {

    @Autowired
    OthersService othersService;

    @ApiOperation("获取微信授权")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "url", value = "授权网页")
    })
    @PostMapping("wxAuthorization")
    public Ajax<Wx> wxAuthorization(@RequestParam String url) {
        return Ajax.ok(WxUtils.wxAuthorization(url));
    }

    /**
     * 上传多个文件
     *
     * @return
     */
    @ApiOperation("获取微信授权")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "url", value = "授权网页")
    })
    @PostMapping("uploadFiles")
    public Ajax uploadFiles(@RequestParam("file") MultipartFile[] files, Boolean small, String path) {
        return Ajax.ok(UploadUtils.uploadFiles(files, small, path));
    }

    /**
     * @param codeBean
     * @return
     */
    @ApiOperation("发送验证码")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "mobile", value = "手机号", required = true),
        @ApiImplicitParam(name = "type", value = "验证码类型", required = true)
    })
    @PostMapping("sendCode")
    public Ajax sendCode(@RequestParam String mobile, @RequestParam CodeType type) {
        othersService.sendCode(mobile, type);
        return Ajax.ok("发送成功");
    }

    @ApiOperation("首页轮播图")
    @PostMapping("homeBannerList")
    public Ajax<List<HomeBannerModel>> homeBannerList() {
        return Ajax.ok(othersService.homeBannerList());
    }
}
