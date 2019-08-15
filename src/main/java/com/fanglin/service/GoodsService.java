package com.fanglin.service;


import com.fanglin.model.SearchGoodsModel;
import com.fanglin.model.goods.GoodsDetailModel;
import com.fanglin.model.goods.HomeGoodsClassModel;
import com.fanglin.model.goods.HomeRecommendGoodsModel;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 商品服务
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/4 10:00
 **/
public interface GoodsService {
    /**
     * 首页商品分类
     * @return
     */
    List<HomeGoodsClassModel> homeGoodsClassList();

    /**
     * 首页推荐商品
     * @return
     */
    List<HomeRecommendGoodsModel> homeHotGoodsList();

    /**
     * 商品分类树
     * @return
     */
    List<HomeGoodsClassModel> goodsClassTree();

    /**
     * 商品名称自动补全
     * @param goodsName 商品名称
     * @return
     */
    List<String> goodsNameAutoCompletion(String goodsName);

    /**
     * 商品搜索
     * @param goodsName
     * @param order
     * @param page
     * @return
     */
    List<SearchGoodsModel> searchGoodsList(String goodsName,String order, RowBounds page);

    /**
     * 商品详情
     * @param id
     * @return
     */
    GoodsDetailModel goodsDetail(Integer id);
}
