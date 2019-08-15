package com.fanglin.controller;

import com.fanglin.common.core.others.Ajax;
import com.fanglin.core.page.Page;
import com.fanglin.model.SearchGoodsModel;
import com.fanglin.model.goods.GoodsDetailModel;
import com.fanglin.model.goods.HomeGoodsClassModel;
import com.fanglin.model.goods.HomeRecommendGoodsModel;
import com.fanglin.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/11 22:37
 **/
@RestController
@RequestMapping("/goods/")
@Api(value = "/goods/", tags = {"商品"})
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @ApiOperation("首页商品分类")
    @PostMapping("homeGoodsClassList")
    public Ajax<List<HomeGoodsClassModel>> homeGoodsClassList() {
        return Ajax.ok(goodsService.homeGoodsClassList());
    }

    @ApiOperation("首页热卖商品")
    @PostMapping("homeHotGoodsList")
    public Ajax<List<HomeRecommendGoodsModel>> homeHotGoodsList() {
        return Ajax.ok(goodsService.homeHotGoodsList());
    }

    @ApiOperation("商品分类树")
    @PostMapping("goodsClassTree")
    public Ajax<List<HomeGoodsClassModel>> goodsClassTree() {
        return Ajax.ok(goodsService.goodsClassTree());
    }

    @ApiOperation("商品名称自动补全")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "goodsName", value = "商品名称", required = true)
    })
    @PostMapping("goodsNameAutoCompletion")
    public Ajax<List<String>> goodsNameAutoCompletion(@RequestParam String goodsName) {
        return Ajax.ok(goodsService.goodsNameAutoCompletion(goodsName));
    }

    @ApiOperation("商品搜索")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "goodsName", value = "商品名称"),
        @ApiImplicitParam(name = "order", value = "排序规则")
    })
    @PostMapping("searchGoodsList")
    public Ajax<List<SearchGoodsModel>> searchGoodsList(String goodsName, String order, RowBounds page) {
        return Ajax.ok(goodsService.searchGoodsList(goodsName, order, page));
    }

    @ApiOperation("商品详情")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "商品id", required = true)
    })
    @PostMapping("goodsDetail")
    public Ajax<GoodsDetailModel> goodsDetail(@RequestParam Integer id) {
        return Ajax.ok(goodsService.goodsDetail(id));
    }
}
