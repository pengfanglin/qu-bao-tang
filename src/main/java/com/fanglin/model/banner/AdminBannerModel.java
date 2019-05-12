package com.fanglin.model.banner;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 轮播图
 *
 * @author 彭方林
 * @date 2019-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "BannerEntity对象", description = "管理端轮播图")
public class AdminBannerModel implements Serializable {

    private Integer bannerId;

    @ApiModelProperty("标题")
    private String bannerTitle;

    @ApiModelProperty("图片")
    private String bannerImg;

    @ApiModelProperty("内链url")
    private String bannerUrl;

    @ApiModelProperty("common:普通 goods:商品 chain:外链")
    private String bannerType;

    @ApiModelProperty("介绍")
    private String bannerDesc;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    @ApiModelProperty("排序")
    private BigDecimal sort;

    @ApiModelProperty("home:所有主页 wx_home:微信首页 pc_home:PC主页 app_home:app主页")
    private String bannerPosition;

    @ApiModelProperty("轮播图商品id")
    private Integer goodsId;

    @ApiModelProperty("外链url")
    private String chainUrl;

    @ApiModelProperty("内容")
    private String content;
}
