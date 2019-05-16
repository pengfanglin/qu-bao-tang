package com.fanglin.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户
 *
 * @author 彭方林
 * @date 2019-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserModel对象", description = "用户")
public class UserModel implements Serializable {

    @ApiModelProperty(value = "主键")
    private Integer userId;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "微信openid")
    private String openId;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "头像图片路径")
    private String headImage;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "年龄")
    private String age;

    @ApiModelProperty(value = "生日")
    private String birthday;

    @ApiModelProperty(value = "用户支付密码")
    private String payPassword;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "积分值")
    private Integer integral;

    @ApiModelProperty(value = "总余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "是否冻结")
    private String isDisable;
}
