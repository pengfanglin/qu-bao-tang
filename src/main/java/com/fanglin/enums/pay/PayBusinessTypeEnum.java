package com.fanglin.enums.pay;


import com.fanglin.common.core.enums.CodeEnum;
import lombok.Getter;

/**
 * 支付业务类型
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/4/10 19:40
 **/
public enum PayBusinessTypeEnum implements CodeEnum {
    //测试支付
    TEST(0);

    /**
     * 业务类型
     */
    @Getter
    private int code;

    PayBusinessTypeEnum(int code) {
        this.code = code;
    }

}