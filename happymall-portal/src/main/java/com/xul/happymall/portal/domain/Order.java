package com.xul.happymall.portal.domain

import com.xul.happymall.base.enums.OrderStatus
import com.xul.happymall.base.enums.PaymentType

/**
 * 订单表
 * Created by lxu on 2018/12/11.
 */
class Order {

    /**
     * 订单号
     */
    private String orderNo

    /**
     * 用户ID
     */
    private Integer userId

    /**
     * 收货地址ID
     */
    private Integer addressId

    /**
     * 实际付款金额,单位是元,保留两位小数
     */
    private BigDecimal payment

    /**
     * 支付类型
     */
    private PaymentType paymentType

    /**
     * 运费,单位是元
     */
    private BigDecimal postage

    /**
     * 订单状态
     */
    private OrderStatus orderStatus

    /**
     * 支付时间
     */
    private Date paymentTime

    /**
     * 发货时间
     */
    private Date sendTime

    /**
     * 交易完成时间
     */
    private Date endTime

    /**
     * 交易关闭时间
     */
    private Date closeTime

    @Override
    String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", userId=" + userId +
                ", addressId=" + addressId +
                ", payment=" + payment +
                ", paymentType=" + paymentType +
                ", postage=" + postage +
                ", orderStatus=" + orderStatus +
                ", paymentTime=" + paymentTime +
                ", sendTime=" + sendTime +
                ", endTime=" + endTime +
                ", closeTime=" + closeTime +
                '}'
    }
}