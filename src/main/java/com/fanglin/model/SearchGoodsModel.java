package com.fanglin.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 商品搜索列表
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/19 17:24
 **/
@Data
@Accessors(chain = true)
public class SearchGoodsModel {
    /**
     * id
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
     * 库存
     */
    private String stock;
    /**
     * 价格
     */
    private String nowPrice;
    /**
     * 销量
     */
    private String totalSales;
}
