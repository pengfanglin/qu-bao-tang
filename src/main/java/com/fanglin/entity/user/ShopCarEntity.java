package com.fanglin.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 购物车
 *
 * @author 彭方林
 * @date 2019-05-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "shop_car")
public class ShopCarEntity implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 规格id
     */
    private Integer specificationId;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否删除
     */
    @LogicDelete
    private String isDelete;
}
