package com.balloon.core.exception.enums;

import com.balloon.core.exception.IBaseExceptionEnums;

/**
 * balloon-core 项目基础异常
 * @author liaofuxing
 * @E-mail liaofuxing@outlook.com
 * @date 2020/10/17 21:40
 **/
public enum BalloonCoreExceptionEnums implements IBaseExceptionEnums {

    PARAMETER_ERROR(1001, "输入参数异常");

    private final Integer code;

    private final String msg;


    BalloonCoreExceptionEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
