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
 * 商品规格总表
 *
 * @author 彭方林
 * @date 2019-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "specification")
public class SpecificationEntity implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 型号名称
     */
    private String name;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 权重
     */
    private BigDecimal sort;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否删除
     */
    private String isDelete;
}
