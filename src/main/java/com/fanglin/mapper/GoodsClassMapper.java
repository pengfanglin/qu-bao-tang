package com.fanglin.mapper;

import com.fanglin.entity.goods.GoodsClassEntity;
import com.fanglin.model.goods.HomeGoodsClassModel;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 商品分类 Mapper 接口
 *
 * @author 彭方林
 * @date 2019-05-11
 */
public interface GoodsClassMapper extends Mapper<GoodsClassEntity> {

    /**
     * 首页商品分类
     * @return
     */
    @Select("select class_id,class_name,class_img from goods_class where parent_id=-1 and is_recommend=1 order by sort desc,class_id asc limit 9 ")
    List<HomeGoodsClassModel> homeGoodsClassList();

    /**
     * 商品分类树
     * @return
     */
    List<HomeGoodsClassModel> goodsClassTree();
}