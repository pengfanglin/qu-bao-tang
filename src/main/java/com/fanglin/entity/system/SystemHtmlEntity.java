package com.fanglin.entity.system;

import lombok.Data;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.LogicDelete;
import tk.mybatis.mapper.annotation.Order;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统html(关于我们,用户须知等等)
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:42
 **/
@Data
@Accessors(chain = true)
@Table(name = "system_html")
public class SystemHtmlEntity implements Serializable {
    /**
     * 主键
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * url路径
     */
    private String url;
    /**
     * 权重
     */
    private Float sort;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 是否删除
     */
    @LogicDelete
    public String isDelete;
}
