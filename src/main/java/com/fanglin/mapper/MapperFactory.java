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
    /**
     * 其他
     */
    @Autowired
    public OthersMapper others;
    /**
     * 系统html
     */
    @Autowired
    public SystemHtmlMapper systemHtml;
    /**
     * 购物车
     **/
    @Autowired
    public ShopCarMapper shopCar;
    /**
     * 用户
     **/
    @Autowired
    public UserMapper user;
    /**
     * 用户搜索记录
     **/
    @Autowired
    public HotSearchMapper hotSearch;
    /**
     * 商品
     **/
    @Autowired
    public GoodsMapper goods;
    /**
     * 商品分类
     */
    @Autowired
    public GoodsClassMapper goodsClass;
    /**
     * 轮播图
     */
    @Autowired
    public BannerMapper banner;
    /**
     * 支付记录
     **/
    @Autowired
    public PayHistoryMapper payHistory;
    /**
     * 退款记录
     **/
    @Autowired
    public RefundHistoryMapper refundHistory;
    /**
     * 商品规格组合
     **/
    @Autowired
    public GoodsSpecificationMapper goodsSpecification;
    /**
     * 商品规格总表
     **/
    @Autowired
    public SpecificationMapper specification;
}
