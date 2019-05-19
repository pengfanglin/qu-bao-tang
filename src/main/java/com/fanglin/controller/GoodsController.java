package com.fanglin.controller;

import com.fanglin.core.others.Ajax;
import com.fanglin.core.page.Page;
import com.fanglin.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/11 22:37
 **/
@RestController
@RequestMapping("/goods/")
@Api(value = "/goods/",description = "商品")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @ApiOperation("首页商品分类")
    @PostMapping("homeGoodsClassList")
    public Ajax homeGoodsClassList(){
        return Ajax.ok(goodsService.homeGoodsClassList());
    }

    @ApiOperation("首页热卖商品")
    @PostMapping("homeHotGoodsList")
    public Ajax homeHotGoodsList(){
        return Ajax.ok(goodsService.homeHotGoodsList());
    }

    @ApiOperation("商品分类树")
    @PostMapping("goodsClassTree")
    public Ajax goodsClassTree(){
        return Ajax.ok(goodsService.goodsClassTree());
    }

    @ApiOperation("商品名称自动补全")
    @PostMapping("goodsNameAutoCompletion")
    public Ajax goodsNameAutoCompletion(String goodsName){
        return Ajax.ok(goodsService.goodsNameAutoCompletion(goodsName));
    }

    @ApiOperation("商品搜索")
    @PostMapping("searchGoodsList")
    public Ajax searchGoodsList(String goodsName,String order, Page page){
        return Ajax.ok(goodsService.searchGoodsList(goodsName,order,page));
    }

    @ApiOperation("商品详情")
    @PostMapping("goodsDetail")
    public Ajax goodsDetail(Integer id){
        return Ajax.ok(goodsService.goodsDetail(id));
    }
}
