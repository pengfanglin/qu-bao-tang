package com.fanglin.service.impl;

import com.fanglin.annotation.LocalCache;
import com.fanglin.mapper.MapperFactory;
import com.fanglin.model.goods.HomeGoodsClassModel;
import com.fanglin.model.goods.HomeRecommendGoodsModel;
import com.fanglin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    MapperFactory mapperFactory;

    @Override
    @LocalCache(value = "home_goods_class",timeout = 1,unit = TimeUnit.DAYS)
    public List<HomeGoodsClassModel> homeGoodsClassList() {
        return mapperFactory.goodsClassMapper.homeGoodsClassList();
    }

    @Override
    @LocalCache(value = "home_recommend_goods",timeout = 1,unit = TimeUnit.DAYS)
    public List<HomeRecommendGoodsModel> homeHotGoodsList() {
        return mapperFactory.goodsMapper.homeHotGoodsList();
    }
}
