package com.fanglin.model.banner;

import com.fanglin.enums.others.BannerTypeEnum;
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
    private String img;

    @ApiModelProperty(value = "url")
    private String url;

    @ApiModelProperty(value = "COMMON:普通 GOODS:商品 CHAIN:外链")
    private BannerTypeEnum type;

    @ApiModelProperty(value = "相关联的业务id")
    private Integer businessId;
}
