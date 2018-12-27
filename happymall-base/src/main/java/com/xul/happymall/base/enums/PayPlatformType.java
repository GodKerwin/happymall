package com.xul.happymall.base.enums;

/**
 * 支付平台
 * Created by lxu on 2018/12/11.
 */
public enum PayPlatformType {

    //支付宝
    ZFB(0, "ZFB"),
    //微信
    WX(1, "WX");

    private int value;
    private String name;

    PayPlatformType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PayPlatformType{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
