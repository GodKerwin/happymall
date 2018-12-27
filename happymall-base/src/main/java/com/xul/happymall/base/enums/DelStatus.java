package com.xul.happymall.base.enums;

/**
 * 删除状态
 * Created by lxu on 2018/12/11.
 */
public enum DelStatus {

    //未删除
    NORMAL(0, "NORMAL"),
    //已删除
    DEL(1, "DEL");

    private int value;
    private String name;

    DelStatus(int value, String name) {
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
        return "DelStatus{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}