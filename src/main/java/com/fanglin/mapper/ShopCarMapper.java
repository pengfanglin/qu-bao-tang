package com.fanglin.mapper;

import com.fanglin.core.page.Page;
import com.fanglin.entity.user.ShopCarEntity;
import com.fanglin.model.user.ShopCarModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 购物车 Mapper 接口
 *
 * @author 彭方林
 * @date 2019-05-16
 */
public interface ShopCarMapper extends Mapper<ShopCarEntity>{
    /**
     * 购物车列表
     *
     * @param userId
     * @param page
     * @return
     */
    @Select("SELECT a.id,a.number,b.id AS goods_id,b.name AS goods_name,c.id AS specification_id,c.names AS specification_name,c.img AS img,c.price AS specification_price FROM shop_car AS a INNER JOIN goods AS b ON a.goods_id=b.id and a.is_delete=0 AND b.state=1 and b.is_delete=0 INNER JOIN goods_specification AS c ON a.specification_id=c.id and c.is_delete=0 WHERE a.user_id=1")
    List<ShopCarModel> shopCarList(Integer userId, RowBounds page);

    /**
     * 批量删除购物车
     * @param userId
     * @param ids
     * @return
     */
    @Update("update shop_car set is_delete=1 where user_id=#{userId} and find_in_set(id,#{ids})")
    int deleteShopCarByIds(@Param("userId") Integer userId, @Param("ids") String ids);
}