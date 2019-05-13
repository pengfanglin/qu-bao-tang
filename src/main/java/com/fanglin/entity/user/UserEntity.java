package com.fanglin.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "user")
public class UserEntity implements Serializable {

    /**
     * 主键
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer userId;

    /**
     * 账号
     */
    private String account;

    /**
     * 微信openid
     */
    private String openId;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户token
     */
    private String token;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像图片路径
     */
    private String headImage;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private String age;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 用户支付密码
     */
    private String payPassword;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 积分值
     */
    private Integer integral;

    /**
     * 总余额
     */
    private BigDecimal balance;

    /**
     * 是否冻结
     */
    private String isDisable;
}