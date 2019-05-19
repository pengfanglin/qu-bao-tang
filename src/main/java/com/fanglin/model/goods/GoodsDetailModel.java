package com.fanglin.model.goods;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 商品详情
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/20 0:17
 **/
@Data
@Accessors(chain = true)
public class GoodsDetailModel {
    /**
     * 商品id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 图片
     */
    private String img;
    /**
     * 轮播图图片，逗号分隔
     */
    private String bannerImages;
    /**
     * 现价
     */
    private String nowPrice;
    /**
     * 销量
     */
    private String totalSales;
    /**
     * 总评分
     */
    private Float totalStar;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 宝贝描述
     */
    private Float star1;
    /**
     * 物流服务
     */
    private Float star2;
    /**
     * 商家服务
     */
    private Float star3;
}
