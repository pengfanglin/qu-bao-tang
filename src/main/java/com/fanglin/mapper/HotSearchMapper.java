package com.fanglin.mapper;

import com.fanglin.entity.user.HotSearchEntity;
import com.fanglin.model.user.HotSearchModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户搜索记录 Mapper 接口
 *
 * @author 彭方林
 * @date 2019-05-12
 */
public interface HotSearchMapper extends Mapper<HotSearchEntity> {

    /**
     * 用户搜索记录
     * @param userId
     * @return
     */
    @Select("select id,content from hot_search where user_id=#{userId} and is_delete=0 order by count desc,id asc limit 10")
    List<HotSearchModel> userSearchHistoryList(@Param("userId") Integer userId);

    /**
     * 热搜记录
     * @param userId
     * @return
     */
    @Select("select id,content from hot_search order by count desc,id asc limit 10")
    List<HotSearchModel> hostSearchList();
}