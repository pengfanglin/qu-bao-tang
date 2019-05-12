package com.fanglin.entity.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "hot_search")
public class HotSearchEntity implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 搜索内容
     */
    private String content;

    /**
     * 搜索次数
     */
    private Integer count;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 0-未删除 1-用户已删除
     */
    private String isDelete;
}
