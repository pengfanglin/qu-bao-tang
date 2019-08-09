package com.fanglin.enums.pay;


import com.fanglin.common.core.enums.CodeEnum;
import lombok.Getter;

/**
 * 支付用户类型（根据creatorType和creatorId唯一确定一条支付记录)
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/10 19:40
 **/
public enum PayCreatorTypeEnum implements CodeEnum {
    /**
     * 用户
     */
    USER(0),
    /**
     * 公共支付用户对象
     */
    COMMON(1);

    /**
     * 支付方式
     */
    @Getter
    private int code;


    PayCreatorTypeEnum(int code) {
        this.code = code;
    }
}