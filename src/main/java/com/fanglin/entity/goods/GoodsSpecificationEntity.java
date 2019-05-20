package com.fanglin.entity.goods;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品规格组合
 *
 * @author 彭方林
 * @date 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "goods_specification")
public class GoodsSpecificationEntity implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 0-下架 1-上架
     */
    private Integer state;

    /**
     * 规格sku
     */
    private String sku;

    /**
     * 规格组合
     */
    private String ids;

    /**
     * 规格名称组合
     */
    private String names;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 图片
     */
    private String img;

    /**
     * 价格
     */
    private BigDecimal price;

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
