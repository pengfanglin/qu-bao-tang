package com.fanglin.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 通用mapper的总仓库
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/3 16:34
 **/
@Component
public class MapperFactory {
    @Autowired
    public OthersMapper othersMapper;
    @Autowired
    public SystemHtmlMapper systemHtmlMapper;
    @Autowired
    public HtmlStyleMapper htmlStyleMapper;
    /**
     * 购物车
     **/
    @Autowired
    public ShopCarMapper shopCarMapper;
    /**
     * 用户
     **/
    @Autowired
    public UserMapper userMapper;
    /**
     * 用户搜索记录
     **/
    @Autowired
    public HotSearchMapper hotSearchMapper;
    /**
     * 商品
     **/
    @Autowired
    public GoodsMapper goodsMapper;
    /**
     * 商品分类
     */
    @Autowired
    public GoodsClassMapper goodsClassMapper;
    /**
     * 轮播图
     */
    @Autowired
    public BannerMapper bannerMapper;
    /**
     * 支付记录
     **/
    @Autowired
    public PayHistoryMapper payHistoryMapper;
    /**
     * 退款记录
     **/
    @Autowired
    public RefundHistoryMapper refundHistoryMapper;
    /**
     * 商品规格组合
     **/
    @Autowired
    public GoodsSpecificationMapper goodsSpecificationMapper;
    /**
     * 商品规格总表
     **/
    @Autowired
    public SpecificationMapper specificationMapper;
}
