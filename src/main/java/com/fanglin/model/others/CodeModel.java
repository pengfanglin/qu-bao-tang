package com.fanglin.model.others;

import com.fanglin.enums.others.CodeType;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 验证码
 *
 * @author 彭方林
 * @version 1.0
 * @date 2019/5/16 19:57
 **/
@Data
@Accessors(chain = true)
public class CodeModel {
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 验证码
     */
    private String code;
    /**
     * 过期时间(秒)
     */
    private int timeout;
    /**
     * redisKey
     */
    private String key;
    /**
     * 验证码内容
     */
    private String content;
    /**
     * 验证码类型
     */
    private CodeType type;
}
