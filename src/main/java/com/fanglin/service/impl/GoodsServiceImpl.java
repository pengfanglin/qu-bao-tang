package com.fanglin.service.impl;

import com.fanglin.common.annotation.LocalCache;
import com.fanglin.common.utils.OthersUtils;
import com.fanglin.mapper.MapperFactory;
import com.fanglin.model.SearchGoodsModel;
import com.fanglin.model.goods.*;
import com.fanglin.service.GoodsService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @LocalCache(value = "home_goods_class", timeout = 1, unit = TimeUnit.DAYS)
    public List<HomeGoodsClassModel> homeGoodsClassList() {
        return mapperFactory.goodsClass.homeGoodsClassList();
    }

    @Override
    @LocalCache(value = "home_recommend_goods", timeout = 1, unit = TimeUnit.DAYS)
    public List<HomeRecommendGoodsModel> homeHotGoodsList() {
        return mapperFactory.goods.homeHotGoodsList();
    }

    @Override
    @LocalCache(value = "goods_class_tree", timeout = 1, unit = TimeUnit.DAYS)
    public List<HomeGoodsClassModel> goodsClassTree() {
        return mapperFactory.goodsClass.goodsClassTree();
    }

    @Override
    public List<String> goodsNameAutoCompletion(String goodsName) {
        return mapperFactory.goods.goodsNameAutoCompletion(goodsName);
    }

    @Override
    public List<SearchGoodsModel> searchGoodsList(String goodsName, String order, RowBounds page) {
        return mapperFactory.goods.searchGoodsList(goodsName, order, page);
    }

    @Override
    public GoodsDetailModel goodsDetail(Integer id) {
        //商品详情
        GoodsDetailModel goodsDetail = mapperFactory.goods.goodsDetail(id);
        if (goodsDetail != null) {
            //商品拥有的规格
            List<GoodsSpecificationModel> goodsSpecifications = mapperFactory.goodsSpecification.getGoodsSpecifications(id);
            goodsDetail.setGoodsSpecifications(goodsSpecifications);
            //商品的总规格
            List<SpecificationModel> specifications = this.getGoodsSpecifications(id);
            //将商品总规格按照类别分组
            List<SpecificationModel> tempSpecifications = new ArrayList<>();
            if (OthersUtils.notEmpty(goodsDetail.getGoodsSpecifications())) {
                String[] ids = goodsSpecifications.get(0).getIds().split(",");
                for (String id1 : ids) {
                    for (SpecificationModel parent : specifications) {
                        for (SpecificationModel child : parent.getSpecifications()) {
                            if (id1.equals(child.getId().toString())) {
                                tempSpecifications.add(parent);
                                break;
                            }
                        }
                    }
                }
            }
            goodsDetail.setSpecifications(tempSpecifications);
        }
        return goodsDetail;
    }

    /**
     * 通过商品id获取商品规格信息
     */
    private List<SpecificationModel> getGoodsSpecifications(Integer goodsId) {
        List<SpecificationModel> parentSpecifications = mapperFactory.goods.getGoodsSpecificationParent(goodsId);
        for (SpecificationModel specification : parentSpecifications) {
            List<SpecificationModel> childSpecifications = mapperFactory.goods.getGoodsSpecificationChild(goodsId, specification.getId());
            specification.setSpecifications(childSpecifications);
        }
        return parentSpecifications;
    }
}
