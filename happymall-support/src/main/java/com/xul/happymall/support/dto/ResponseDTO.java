package com.xul.happymall.support.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xul.happymall.support.enums.ExceptionEnum;
import com.xul.happymall.support.exception.HappymallSystemException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by lxu on 2018/12/05.
 */
@ApiModel(value = "返回对象", description = "restful公共返回对象")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> implements Serializable {

    public static ResponseDTO<?> success(Object obj) {
        ExceptionEnum success = ExceptionEnum.SUCCESS;
        return new ResponseDTO<>(success.getCode(), success.getMsg(), obj);
    }

    public static ResponseDTO success() {
        return success(null);
    }

    public static ResponseDTO error(HappymallSystemException e) {
        return new ResponseDTO(e.getCode(), e.getMessage());
    }

    public static ResponseDTO error(Integer code, String msg) {
        return new ResponseDTO(code, msg);
    }

    public ResponseDTO() {
    }

    private ResponseDTO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private ResponseDTO(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码", name = "code", example = "1")
    private Integer code;

    /**
     * 提示信息
     */
    @ApiModelProperty(value = "提示信息", name = "message", example = "成功")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据", name = "data", example = "object")
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
