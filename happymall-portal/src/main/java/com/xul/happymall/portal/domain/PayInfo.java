package com.xul.happymall.portal.domain

import com.xul.happymall.base.enums.PayPlatformType

/**
 * 支付表
 * Created by lxu on 2018/12/11.
 */
class PayInfo {

    /**
     * 用户ID
     */
    private Integer userId

    /**
     * 订单号
     */
    private Long orderNo

    /**
     * 支付平台
     */
    private PayPlatformType payPlatformType

    /**
     * 支付宝支付流水号
     */
    private String platformNumber

    /**
     * 支付宝支付状态
     */
    private String platformStatus

    @Override
    String toString() {
        return "PayInfo{" +
                "userId=" + userId +
                ", orderNo=" + orderNo +
                ", payPlatformType=" + payPlatformType +
                ", platformNumber='" + platformNumber + '\'' +
                ", platformStatus='" + platformStatus + '\'' +
                '}'
    }
}