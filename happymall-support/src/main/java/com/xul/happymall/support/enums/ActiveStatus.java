package com.xul.happymall.support.enums;

/**
 * 生效状态 0-生效 1-失效
 * Created by lxu on 2018/12/11.
 */
public enum ActiveStatus {

    //生效
    ACTIVE(0, "ACTIVE"),
    //未生效
    INACTIVE(1, "INACTIVE");

    public static final String DEFAULT = "0";

    private final int value;
    private final String name;

    ActiveStatus(int value, String name) {
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
        return "ActiveStatus{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}