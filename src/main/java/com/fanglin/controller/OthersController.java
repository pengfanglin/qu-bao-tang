package com.fanglin.controller;

import com.fanglin.annotation.Token;
import com.fanglin.core.others.Ajax;
import com.fanglin.core.token.TokenInfo;
import com.fanglin.enums.others.CodeType;
import com.fanglin.model.others.CodeModel;
import com.fanglin.service.OthersService;
import com.fanglin.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;

/**
 * 其他接口控制器
 * @author 彭方林
 * @date 2019/4/3 16:36
 * @version 1.0
 **/
@RestController
@RequestMapping("/others/")
@Api(value = "/others/",description = "其他")
public class OthersController {

	@Autowired
	OthersService othersService;

	/**
	 * 获取微信授权
	 * @param url
	 * @return
	 */
	@PostMapping("getWxAuthorization")
	public Ajax getWXAuthorization(String url){
		return Ajax.ok(WxUtils.getWXAuthorization(url));
	}

	/**
	 * 获取html页面内容
	 * @param url
	 * @return
	 */
	@PostMapping("getHtmlContent")
	public Ajax getHtmlContent(String url){
		String desc=OthersUtils.readHtml(url);
		int start=desc.indexOf("<content>");
		int end=desc.indexOf("</content>");
		if(start>0&&end>0){
			desc=desc.substring(start+9,end);
		}
		return Ajax.ok(desc);
	}

	/**
	 * 上传多个文件
	 * @return
	 */
	@PostMapping("uploadFiles")
	public Ajax uploadFiles(@RequestParam("file") MultipartFile[] files, Boolean small,String path){
		return Ajax.ok(OthersUtils.uploadFiles(files,small,path));
	}

	/**
	 * 发送验证码
	 * @param codeBean
	 * @return
	 */
	@PostMapping("sendCode")
	@Token
	public Ajax sendCode(@RequestParam String mobile, @RequestParam Integer type, TokenInfo tokenInfo){
		othersService.sendCode(new CodeModel().setKey(tokenInfo.getId()+"_"+type).setMobile(mobile));
		return Ajax.ok("发送成功");
	}

	@ApiOperation("首页轮播图")
	@PostMapping("homeBannerList")
	public Ajax homeBannerList(){
		return Ajax.ok(othersService.homeBannerList());
	}
}
