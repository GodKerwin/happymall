package com.xul.happymall.portal.domain

/**
 * 订单明细
 * Created by lxu on 2018/12/11.
 */
class OrderItem {

    /**
     * 订单号
     */
    private String orderNo

    /**
     * 用户ID
     */
    private Integer userId

    /**
     * 商品ID
     */
    private Integer productId

    /**
     * 商品名称
     */
    private String productName

    /**
     * 商品图片地址
     */
    private String productImage

    /**
     * 生成订单时的商品单价，单位是元,保留两位小数
     */
    private BigDecimal currentUnitPrice

    /**
     * 商品数量
     */
    private Integer quantity

    /**
     * 商品总价,单位是元,保留两位小数
     */
    private BigDecimal totalPrice

    @Override
    String toString() {
        return "OrderItem{" +
                "orderNo='" + orderNo + '\'' +
                ", userId=" + userId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", currentUnitPrice=" + currentUnitPrice +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}'
    }
}