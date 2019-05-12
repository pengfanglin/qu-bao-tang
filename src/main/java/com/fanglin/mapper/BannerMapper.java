package com.fanglin.mapper;

import com.fanglin.entity.others.BannerEntity;
import com.fanglin.model.banner.HomeBannerModel;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 轮播图 Mapper 接口
 *
 * @author 彭方林
 * @date 2019-05-11
 */
public interface BannerMapper extends Mapper<BannerEntity> {

    /**
     * 首页轮播图
     * @return
     */
    @Select("select banner_img,banner_url,banner_type,chain_url,goods_id from banner order by sort desc,banner_id asc limit 5")
    List<HomeBannerModel> homeBannerList();
}