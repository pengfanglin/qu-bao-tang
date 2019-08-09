package com.fanglin.controller;

import com.fanglin.common.annotation.Token;
import com.fanglin.common.core.others.Ajax;
import com.fanglin.common.core.others.TokenInfo;
import com.fanglin.model.user.HotSearchModel;
import com.fanglin.model.user.ShopCarModel;
import com.fanglin.model.user.UserModel;
import com.fanglin.service.UserService;
import io.swagger.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用户
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/11 22:37
 **/
@RestController
@RequestMapping("/user/")
@Api(value = "/user/", tags = {"用户"})
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("用户搜索记录")
    @Token
    @PostMapping("userSearchHistoryList")
    public Ajax<List<HotSearchModel>> userSearchHistoryList(TokenInfo token) {
        return Ajax.ok(userService.userSearchHistoryList(token.getId()));
    }

    @ApiOperation("热搜记录")
    @PostMapping("hostSearchList")
    public Ajax<List<HotSearchModel>> hostSearchList() {
        return Ajax.ok(userService.hostSearchList());
    }

    @ApiOperation("用户登录")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "account", value = "账号", required = true),
        @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    @PostMapping("userLogin")
    public Ajax<UserModel> userLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam String account, @RequestParam String password) {
        return Ajax.ok(userService.userLogin(request, response, account, password));
    }

    @ApiOperation("购物车列表")
    @Token
    @PostMapping("shopCarList")
    public Ajax<List<ShopCarModel>> shopCarList(TokenInfo token, RowBounds page) {
        return Ajax.ok(userService.shopCarList(token.getId(), page));
    }

    @ApiOperation("添加购物车记录")
    @Token
    @PostMapping("insertShopCart")
    public Ajax insertShopCart(TokenInfo token, ShopCarModel shopCarModel) {
        userService.insertShopCart(shopCarModel.setUserId(token.getId()));
        return Ajax.ok();
    }

    @ApiOperation("批量删除购物车")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "ids", value = "购物车id,逗号分隔", required = true)
    })
    @Token
    @PostMapping("deleteShopCarByIds")
    public Ajax deleteShopCarByIds(TokenInfo token, @RequestParam String ids) {
        if (userService.deleteShopCarByIds(token.getId(), ids) > 0) {
            return Ajax.ok();
        } else {
            return Ajax.error("删除失败");
        }
    }
}
