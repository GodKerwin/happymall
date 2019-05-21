package com.xul.happymall.support.exception;

import com.xul.happymall.support.enums.ExceptionEnum;

/**
 * Created by lxu on 2018/12/05.
 */
public class HappymallSystemException extends RuntimeException {

    private Integer code;

    public HappymallSystemException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
