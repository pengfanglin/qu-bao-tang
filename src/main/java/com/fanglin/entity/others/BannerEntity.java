package com.fanglin.entity.others;

import com.fanglin.enums.others.BannerTypeEnum;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.LogicDelete;

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
    private Integer id;

    /**
     * 图片
     */
    private String img;

    /**
     * 内链url
     */
    private String bannerUrl;

    /**
     * 0-普通广告 1-商品广告 2-外链广告
     */
    private BannerTypeEnum type;

    /**
     * 介绍
     */
    private String desc;

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
    private Float sort;

    /**
     * 轮播图商品id
     */
    private Integer businessId;

    /**
     * 外链url
     */
    private String chainUrl;

    /**
     * 是否删除
     */
    @LogicDelete
    public String isDelete;
}
