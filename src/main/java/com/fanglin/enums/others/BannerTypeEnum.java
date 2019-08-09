package com.fanglin.enums.others;

import com.fanglin.common.core.enums.CodeEnum;
import lombok.Getter;

/**
 * 轮播图类型
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/19 22:09
 **/
public enum BannerTypeEnum implements CodeEnum {

    /**
     * 普通
     */
    COMMON(0),
    /**
     * 商品
     */
    GOODS(1),
    /**
     * 外链
     */
    CHAIN(2);

    @Getter
    private int code;

    BannerTypeEnum(int code) {
        this.code = code;
    }
}
