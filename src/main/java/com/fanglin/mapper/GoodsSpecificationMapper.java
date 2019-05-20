package com.fanglin.mapper;

import com.fanglin.entity.goods.GoodsSpecificationEntity;
import com.fanglin.model.goods.GoodsSpecificationModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 商品规格组合 Mapper 接口
 *
 * @author 彭方林
 * @date 2019-05-20
 */
public interface GoodsSpecificationMapper extends Mapper<GoodsSpecificationEntity> {

    /**
     * 商品规格列表
     * @param goodsId
     * @return
     */
    @Select("select * from goods_specification where goods_id=#{goodsId} and is_delete=0 order by id asc")
    List<GoodsSpecificationModel> getGoodsSpecifications(@Param("goodsId") Integer goodsId);
}