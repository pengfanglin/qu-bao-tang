package com.fanglin.mapper;

import com.fanglin.entity.goods.GoodsEntity;
import com.fanglin.model.goods.HomeRecommendGoodsModel;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 商品 Mapper 接口
 *
 * @author 彭方林
 * @date 2019-05-12
 */
public interface GoodsMapper extends Mapper<GoodsEntity> {

    /**
     * 首页推荐商品
     * @return
     */
    @Select("select goods_id,name,img,min_price,total_sales from goods where is_recommend=1 and state=1 order by total_sales desc limit 6 ")
    List<HomeRecommendGoodsModel> homeHotGoodsList();
}