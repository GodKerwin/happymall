package com.xul.happymall.base.enums;

/**
 * 激活状态
 * Created by lxu on 2018/12/11.
 */
public enum ActiveStatus {

    //生效
    ACTIVE(0, "ACTIVE"),
    //未生效
    INACTIVE(1, "INACTIVE");

    private int value;
    private String name;

    ActiveStatus(int value, String name) {
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
        return "ActiveStatus{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}