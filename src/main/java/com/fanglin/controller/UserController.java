package com.fanglin.controller;

import com.fanglin.annotation.Token;
import com.fanglin.core.others.Ajax;
import com.fanglin.core.page.Page;
import com.fanglin.core.token.TokenInfo;
import com.fanglin.model.user.ShopCarModel;
import com.fanglin.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/11 22:37
 **/
@RestController
@RequestMapping("/user/")
@Api(value = "/user/",description = "用户")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("用户搜索记录")
    @Token
    @PostMapping("userSearchHistoryList")
    public Ajax userSearchHistoryList(TokenInfo tokenInfo){
        return Ajax.ok(userService.userSearchHistoryList(tokenInfo.getId()));
    }

    @ApiOperation("热搜记录")
    @PostMapping("hostSearchList")
    public Ajax hostSearchList(){
        return Ajax.ok(userService.hostSearchList());
    }

    @ApiOperation("用户登录")
    @PostMapping("userLogin")
    public Ajax userLogin(HttpServletRequest request, HttpServletResponse response,String account,String password){
        return Ajax.ok(userService.userLogin(request,response,account,password));
    }

    @ApiOperation("购物车列表")
    @Token
    @PostMapping("shopCarList")
    public Ajax shopCarList(TokenInfo tokenInfo, Page page){
        return Ajax.ok(userService.shopCarList(tokenInfo.getId(),page));
    }

    @ApiOperation("添加购物车记录")
    @Token
    @PostMapping("insertShopCart")
    public Ajax insertShopCart(TokenInfo tokenInfo, ShopCarModel shopCarModel){
        userService.insertShopCart(shopCarModel.setUserId(tokenInfo.getId()));
        return Ajax.ok();
    }

    @ApiOperation("批量删除购物车")
    @Token
    @PostMapping("deleteShopCarByIds")
    public Ajax deleteShopCarByIds(TokenInfo tokenInfo, String ids){
        if(userService.deleteShopCarByIds(tokenInfo.getId(),ids)>0){
            return Ajax.ok();
        }else{
            return Ajax.error("删除失败");
        }
    }
}
