package com.fanglin.service;


import com.fanglin.model.goods.HomeGoodsClassModel;
import com.fanglin.model.goods.HomeRecommendGoodsModel;

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
}
