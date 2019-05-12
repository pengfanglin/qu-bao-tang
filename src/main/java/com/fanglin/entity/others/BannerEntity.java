package com.fanglin.entity.others;

import io.swagger.annotations.ApiModel;
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
 * 轮播图
 *
 * @author 彭方林
 * @date 2019-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "banner")
public class BannerEntity implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer bannerId;

    /**
     * 标题
     */
    private String bannerTitle;

    /**
     * 图片
     */
    private String bannerImg;

    /**
     * 内链url
     */
    private String bannerUrl;

    /**
     * common:普通 goods:商品 chain:外链
     */
    private String bannerType;

    /**
     * 介绍
     */
    private String bannerDesc;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 排序
     */
    private BigDecimal sort;

    /**
     * home:所有主页 wx_home:微信首页 pc_home:PC主页 app_home:app主页
     */
    private String bannerPosition;

    /**
     * 轮播图商品id
     */
    private Integer goodsId;

    /**
     * 外链url
     */
    private String chainUrl;
}
