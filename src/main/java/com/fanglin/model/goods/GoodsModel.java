package com.fanglin.model.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@ApiModel(value = "GoodsModel对象", description = "商品")
public class GoodsModel implements Serializable {

    private Integer goodsId;

    @ApiModelProperty(value = "商品分类id")
    private Integer classId;

    @ApiModelProperty(value = "商品编码")
    private String code;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "图片")
    private String img;

    @ApiModelProperty(value = "最大规格价格")
    private BigDecimal maxPrice;

    @ApiModelProperty(value = "最小规格价格")
    private BigDecimal minPrice;

    @ApiModelProperty(value = "现价")
    private String nowPrice;

    @ApiModelProperty(value = "商品简介")
    private String goodsDesc;

    @ApiModelProperty(value = "详情web地址")
    private String infoUrl;

    @ApiModelProperty(value = "总销量")
    private Integer totalSales;

    @ApiModelProperty(value = "月销量")
    private Integer monthSales;

    @ApiModelProperty(value = "日销量")
    private Integer daySales;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @ApiModelProperty(value = "宝贝描述")
    private BigDecimal star1;

    @ApiModelProperty(value = "物流服务")
    private BigDecimal star2;

    @ApiModelProperty(value = "商家服务")
    private BigDecimal star3;

    @ApiModelProperty(value = "总的星级")
    private BigDecimal totalStar;

    @ApiModelProperty(value = "评价数量")
    private Integer assessmentCount;

    @ApiModelProperty(value = "状态1上架0下架")
    private String state;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "赠送积分值")
    private Integer giveIntegral;

    @ApiModelProperty(value = "邮费")
    private Integer expressPrice;
}
