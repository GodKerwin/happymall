package com.xul.happymall.base.enums;

/**
 * 订单状态 0-已取消 1-未付款 2-已付款 3-已发货 4-交易成功 5-交易关闭
 * Created by lxu on 2018/12/11.
 */
public enum OrderStatus {

    //已取消
    CANCEL(0, "CANCEL"),
    //未付款
    NOPAY(1, "NOPAY"),
    //已付款
    PAYED(2, "PAYED"),
    //已发货
    SENDOUT(3, "SENDOUT"),
    //交易成功
    SUCCESS(4, "SUCCESS"),
    //交易关闭
    CLOSE(5, "CLOSE");

    private final int value;
    private final String name;

    OrderStatus(int value, String name) {
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
        return "OrderStatus{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}