package com.xul.happymall.base.enums;

/**
 * 支付类型 0-在线支付
 * Created by lxu on 2018/12/11.
 */
public enum PaymentType {

    //在线支付
    ONLINE(0, "ONLINE");

    private final int value;
    private final String name;

    PaymentType(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
