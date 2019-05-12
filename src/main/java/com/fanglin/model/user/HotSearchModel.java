package com.fanglin.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户搜索记录
 *
 * @author 彭方林
 * @date 2019-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "HotSearchModel对象", description = "用户搜索记录")
public class HotSearchModel implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "搜索内容")
    private String content;

    @ApiModelProperty(value = "搜索次数")
    private Integer count;
}
