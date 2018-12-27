package com.xul.happymall.base.enums;

/**
 * 支付类型（待扩展）
 * Created by lxu on 2018/12/11.
 */
public enum PaymentType {

    //在线支付
    ONLINE(0, "ONLINE");

    private int value;
    private String name;

    PaymentType(int value, String name) {
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
        return "PaymentType{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
