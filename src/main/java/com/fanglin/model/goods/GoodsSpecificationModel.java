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
 * 商品规格组合
 *
 * @author 彭方林
 * @date 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "GoodsSpecificationModel对象", description = "商品规格组合")
public class GoodsSpecificationModel implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "商品id")
    private Integer goodsId;

    @ApiModelProperty(value = "0-下架 1-上架")
    private Integer state;

    @ApiModelProperty(value = "规格sku")
    private String sku;

    @ApiModelProperty(value = "规格组合")
    private String ids;

    @ApiModelProperty(value = "规格名称组合")
    private String names;

    @ApiModelProperty(value = "销量")
    private Integer sales;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @ApiModelProperty(value = "图片")
    private String img;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
