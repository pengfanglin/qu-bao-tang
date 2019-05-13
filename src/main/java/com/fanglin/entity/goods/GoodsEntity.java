package com.fanglin.entity.goods;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 *
 * @author 彭方林
 * @date 2019-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "goods")
public class GoodsEntity implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer goodsId;

    /**
     * 商家id
     */
    private Integer merchantsId;

    /**
     * 商品分类id
     */
    private Integer classId;

    /**
     * 商品编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 图片
     */
    private String img;

    /**
     * 最大规格价格
     */
    private BigDecimal maxPrice;

    /**
     * 最小规格价格
     */
    private BigDecimal minPrice;

    /**
     * 现价
     */
    private String nowPrice;

    /**
     * 商品简介
     */
    private String goodsDesc;

    /**
     * 详情web地址
     */
    private String infoUrl;

    /**
     * 总销量
     */
    private Integer totalSales;

    /**
     * 月销量
     */
    private Integer monthSales;

    /**
     * 日销量
     */
    private Integer daySales;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 宝贝描述
     */
    private BigDecimal star1;

    /**
     * 物流服务
     */
    private BigDecimal star2;

    /**
     * 商家服务
     */
    private BigDecimal star3;

    /**
     * 总的星级
     */
    private BigDecimal totalStar;

    /**
     * 评价数量
     */
    private Integer assessmentCount;

    /**
     * 状态1上架0下架
     */
    private String state;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 赠送积分值
     */
    private Integer giveIntegral;

    /**
     * 邮费
     */
    private Integer expressPrice;
}