package com.fanglin.model.banner;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/11 23:46
 **/
@Data
@Accessors(chain = true)
@ApiModel(value = "BannerEntity对象", description = "轮播图")
public class HomeBannerModel implements Serializable {

    @ApiModelProperty(value = "图片")
    private String bannerImg;

    @ApiModelProperty(value = "内链url")
    private String bannerUrl;

    @ApiModelProperty(value = "common:普通 goods:商品 chain:外链")
    private String bannerType;

    @ApiModelProperty(value = "轮播图商品id")
    private Integer goodsId;

    @ApiModelProperty(value = "外链url")
    private String chainUrl;
}
