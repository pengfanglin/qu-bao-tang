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
 * 首页推荐商品
 *
 * @author 彭方林
 * @date 2019-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "GoodsModel对象", description = "首页推荐商品")
public class HomeRecommendGoodsModel implements Serializable {

    private Integer goodsId;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "图片")
    private String img;

    @ApiModelProperty(value = "最小规格价格")
    private String minPrice;

    @ApiModelProperty(value = "总销量")
    private Integer totalSales;
}
