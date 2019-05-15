package com.fanglin.entity.goods;

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
 * 商品分类
 *
 * @author 彭方林
 * @date 2019-05-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "goods_class")
public class GoodsClassEntity implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类描述
     */
    private String desc;

    /**
     * 分类图标
     */
    private String img;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 父id组合
     */
    private String parentIds;

    /**
     * 权重
     */
    private BigDecimal sort;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 是否首页推荐
     */
    private String isRecommend;
}
