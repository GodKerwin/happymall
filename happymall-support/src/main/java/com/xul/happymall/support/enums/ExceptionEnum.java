package com.xul.happymall.support.enums;

/**
 * 异常枚举
 * Created by lxu on 2018/12/05.
 */
public enum ExceptionEnum {

    //公共异常
    NEED_LOGIN(-1, "Unauthorized"),
    SUCCESS(0, "成功"),
    UNKNOW_ERROR(1, "未知错误"),
    DATA_ERROR(2, "数据操作异常"),
    ILLEGAL_ARGUMENT(3, "参数异常"),
    ARGUMENT_NOTNULL(4, "参数%s不能为空"),

    //系统功能异常
    MAIL_EXCEPTION(100, "激活邮件发送失败"),

    //用户业务异常
    LOGIN_ERROR(200, "用户名或密码错误"),
    USER_EXIST(201, "用户名已被占用"),
    EMAIL_EXIST(202, "邮箱已被占用"),
    ACCOUNT_INACTIVE(203, "账户邮箱未激活"),
    ACTIVECODE_NOT_EXIST(204, "激活码不存在"),
    ACCOUNT_ACTIVATION(205, "用户已激活"),
    ANSWER_ERROR(206, "找回密码问题答案错误"),
    USER_NOT_EXIST(207, "用户名不存在"),
    EMAIL_NOT_EXIST(208, "邮箱不存在"),
    TOKEN_EXPIRED(209, "token无效或已过期"),
    OLD_PASSWORD_ERROR(210, "旧密码错误"),
    UPDATE_PASSWORD_ERROR(211, "修改密码失败"),
    UPDATE_INFORMATION_ERROR(211, "更新个人信息失败"),
    ;

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 提示信息
     */
    private final String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ExceptionEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
