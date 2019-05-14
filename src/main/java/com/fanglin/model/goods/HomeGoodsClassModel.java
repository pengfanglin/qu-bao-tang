package com.fanglin.model.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 首页商品分类
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/11 22:42
 **/
@Data
@Accessors(chain = true)
@ApiModel(value = "GoodsClassEntity对象", description = "商品分类")
public class HomeGoodsClassModel {

    @ApiModelProperty("主键")
    private Integer classId;

    @ApiModelProperty("名称")
    private String className;

    @ApiModelProperty("图标")
    private String classImg;

    @ApiModelProperty("子分类列表")
    private List<HomeGoodsClassModel> goodsClassModels;
}
