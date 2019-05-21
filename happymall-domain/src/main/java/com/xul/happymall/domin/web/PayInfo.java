package com.xul.happymall.domin.web;

import com.xul.happymall.domin.BaseModel;
import com.xul.happymall.support.constant.HappymallConstant;
import com.xul.happymall.support.enums.DelStatus;
import com.xul.happymall.support.enums.PayPlatformType;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 支付表
 * Created by lxu on 2018/12/11.
 */
@Entity
@Table(name = HappymallConstant.TABLE_NAME_PREFIX + "pay_info")
@Where(clause = "delStatus = " + DelStatus.DEFAULT)
class PayInfo extends BaseModel {

    /**
     * 用户ID
     */
    @Column(name = "userId", columnDefinition = "int(11) NOT NULL COMMENT '用户ID'")
    private Integer userId;

    /**
     * 订单号
     */
    @Column(name = "orderNo", columnDefinition = "varchar(20) NOT NULL COMMENT '订单号'")
    private String orderNo;

    /**
     * 支付平台
     */
    @Column(name = "payPlatformType", columnDefinition = "tinyint(1) NOT NULL COMMENT '支付平台 0-支付宝 1-微信'")
    private PayPlatformType payPlatformType;

    /**
     * 支付宝支付流水号
     */
    @Column(name = "platformNumber", columnDefinition = "varchar(200) NOT NULL COMMENT '支付宝支付流水号'")
    private String platformNumber;

    /**
     * 支付宝支付状态
     */
    @Column(name = "platformStatus", columnDefinition = "varchar(20) NOT NULL COMMENT '支付宝支付状态'")
    private String platformStatus;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public PayPlatformType getPayPlatformType() {
        return payPlatformType;
    }

    public void setPayPlatformType(PayPlatformType payPlatformType) {
        this.payPlatformType = payPlatformType;
    }

    public String getPlatformNumber() {
        return platformNumber;
    }

    public void setPlatformNumber(String platformNumber) {
        this.platformNumber = platformNumber;
    }

    public String getPlatformStatus() {
        return platformStatus;
    }

    public void setPlatformStatus(String platformStatus) {
        this.platformStatus = platformStatus;
    }

}