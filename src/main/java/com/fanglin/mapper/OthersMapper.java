package com.fanglin.mapper;

import com.fanglin.core.page.Page;
import com.fanglin.model.SearchGoodsModel;
import com.fanglin.model.goods.GoodsDetailModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 其他Mapper
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:36
 **/
public interface OthersMapper {

    /**
     * 商品搜索
     * @param goodsName
     * @param order
     * @param page
     * @return
     */
    List<SearchGoodsModel> searchGoodsList(@Param("goodsName") String goodsName, @Param("order") String order, Page page);

    /**
     * 商品详情
     * @param id
     * @return
     */
    GoodsDetailModel goodsDetail(@Param("id") Integer id);
}
