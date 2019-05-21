package com.xul.happymall.support.enums;

/**
 * 是否删除 0-未删除 1-已删除
 * Created by lxu on 2018/12/11.
 */
public enum DelStatus {

    //未删除
    NORMAL(0, "NORMAL"),
    //已删除
    DEL(1, "DEL");

    public static final String DEFAULT = "0";

    private final int value;
    private final String name;

    DelStatus(int value, String name) {
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
        return "DelStatus{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}