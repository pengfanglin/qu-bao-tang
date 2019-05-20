package com.fanglin.model.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 商品规格总表
 *
 * @author 彭方林
 * @date 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SpecificationModel对象", description = "商品规格总表")
public class SpecificationModel implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "型号名称")
    private String name;

    @ApiModelProperty(value = "父id")
    private Integer parentId;

    @ApiModelProperty(value = "权重")
    private BigDecimal sort;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    List<SpecificationModel> specifications;
}
