package com.fanglin.mapper;

import com.fanglin.core.page.Page;
import com.fanglin.entity.goods.GoodsEntity;
import com.fanglin.model.SearchGoodsModel;
import com.fanglin.model.goods.GoodsDetailModel;
import com.fanglin.model.goods.HomeRecommendGoodsModel;
import com.fanglin.model.goods.SpecificationModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
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
     *
     * @return
     */
    @Select("select id,name,img,min_price,total_sales from goods where is_recommend=1 and state=1 order by total_sales desc limit 8 ")
    List<HomeRecommendGoodsModel> homeHotGoodsList();

    /**
     * 商品名称自动补全
     *
     * @param goodsName 商品名称
     * @return
     */
    @Select("select name from goods where name like concat(#{goodsName},'%') limit 10")
    List<String> goodsNameAutoCompletion(@Param("goodsName") String goodsName);

    /**
     * 商品搜索
     *
     * @param goodsName
     * @param order
     * @param page
     * @return
     */
    List<SearchGoodsModel> searchGoodsList(@Param("goodsName") String goodsName, @Param("order") String order, RowBounds page);

    /**
     * 商品详情
     *
     * @param id
     * @return
     */
    GoodsDetailModel goodsDetail(@Param("id") Integer id);

    /**
     * 商品包含的父级规格
     *
     * @param goodsId 商品id
     * @return
     */
    List<SpecificationModel> getGoodsSpecificationParent(@Param("goodsId") Integer goodsId);

    /**
     * 商品包含的子级规格
     *
     * @param goodsId  商品id
     * @param parentId 规格父id
     * @return
     */
    List<SpecificationModel> getGoodsSpecificationChild(@Param("goodsId") Integer goodsId, @Param("parentId") Integer parentId);
}