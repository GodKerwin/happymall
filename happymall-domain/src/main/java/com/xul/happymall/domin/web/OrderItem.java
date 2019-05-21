package com.xul.happymall.domin.web;

import com.xul.happymall.domin.BaseModel;
import com.xul.happymall.support.constant.HappymallConstant;
import com.xul.happymall.support.enums.DelStatus;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 订单明细
 * Created by lxu on 2018/12/11.
 */
@Entity
@Table(name = HappymallConstant.TABLE_NAME_PREFIX + "order_item")
@Where(clause = "delStatus = " + DelStatus.DEFAULT)
class OrderItem extends BaseModel {

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
     * 商品ID
     */
    @Column(name = "productId", columnDefinition = "int(11) NOT NULL COMMENT '商品ID'")
    private Integer productId;

    /**
     * 商品名称
     */
    @Column(name = "productName", columnDefinition = "varchar(100) NOT NULL COMMENT '商品名称'")
    private String productName;

    /**
     * 商品图片地址
     */
    @Column(name = "productImage", columnDefinition = "varchar(500) NOT NULL COMMENT '商品图片地址'")
    private String productImage;

    /**
     * 生成订单时的商品单价，单位是元,保留两位小数
     */
    @Column(name = "currentUnitPrice", columnDefinition = "decimal(20,2) DEFAULT NULL COMMENT '生成订单时的商品单价，单位是元,保留两位小数'")
    private BigDecimal currentUnitPrice;

    /**
     * 商品数量
     */
    @Column(name = "quantity", columnDefinition = "int(11) NOT NULL COMMENT '商品数量'")
    private Integer quantity;

    /**
     * 商品总价,单位是元,保留两位小数
     */
    @Column(name = "totalPrice", columnDefinition = "decimal(20,2) DEFAULT NULL COMMENT '商品总价,单位是元,保留两位小数'")
    private BigDecimal totalPrice;

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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public BigDecimal getCurrentUnitPrice() {
        return currentUnitPrice;
    }

    public void setCurrentUnitPrice(BigDecimal currentUnitPrice) {
        this.currentUnitPrice = currentUnitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

}