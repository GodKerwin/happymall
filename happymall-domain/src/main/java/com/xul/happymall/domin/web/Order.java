package com.xul.happymall.domin.web;

import com.xul.happymall.domin.BaseModel;
import com.xul.happymall.support.constant.HappymallConstant;
import com.xul.happymall.support.enums.DelStatus;
import com.xul.happymall.support.enums.OrderStatus;
import com.xul.happymall.support.enums.PaymentType;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 * Created by lxu on 2018/12/11.
 */
@Entity
@Table(name = HappymallConstant.TABLE_NAME_PREFIX + "order")
@Where(clause = "delStatus = " + DelStatus.DEFAULT)
class Order extends BaseModel {

    /**
     * 订单号
     */
    @Column(name = "orderNo", columnDefinition = "varchar(20) NOT NULL COMMENT '订单号'")
    private String orderNo;

    /**
     * 用户ID
     */
    @Column(name = "userId", columnDefinition = "int(11) NOT NULL COMMENT '用户ID'")
    private Integer userId;

    /**
     * 收货地址ID
     */
    @Column(name = "addressId", columnDefinition = "int(11) NOT NULL COMMENT '收货地址ID'")
    private Integer addressId;

    /**
     * 实际付款金额,单位是元,保留两位小数
     */
    @Column(name = "payment", columnDefinition = "decimal(20,2) DEFAULT NULL COMMENT '实际付款金额,单位是元,保留两位小数'")
    private BigDecimal payment;

    /**
     * 支付类型
     */
    @Column(name = "paymentType", columnDefinition = "tinyint(1) NOT NULL COMMENT '支付类型 0-在线支付'")
    private PaymentType paymentType;

    /**
     * 运费,单位是元,保留两位小数
     */
    @Column(name = "postage", columnDefinition = "decimal(6,2) DEFAULT NULL COMMENT '运费,单位是元,保留两位小数'")
    private BigDecimal postage;

    /**
     * 订单状态
     */
    @Column(name = "orderStatus", columnDefinition = "tinyint(1) DEFAULT '1' COMMENT '订单状态 0-已取消 1-未付款 2-已付款 3-已发货 4-交易成功 5-交易关闭'")
    private OrderStatus orderStatus;

    /**
     * 支付时间
     */
    @Column(name = "paymentTime", columnDefinition = "datetime DEFAULT NULL COMMENT '支付时间'")
    private Date paymentTime;

    /**
     * 发货时间
     */
    @Column(name = "sendTime", columnDefinition = "datetime DEFAULT NULL COMMENT '发货时间'")
    private Date sendTime;

    /**
     * 交易完成时间
     */
    @Column(name = "endTime", columnDefinition = "datetime DEFAULT NULL COMMENT '交易完成时间'")
    private Date endTime;

    /**
     * 交易关闭时间
     */
    @Column(name = "closeTime", columnDefinition = "datetime DEFAULT NULL COMMENT '交易关闭时间'")
    private Date closeTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

}