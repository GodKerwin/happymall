package com.xul.happymall.domin.web;

import com.xul.happymall.domin.BaseModel;
import com.xul.happymall.support.constant.HappymallConstant;
import com.xul.happymall.support.enums.ActiveStatus;
import com.xul.happymall.support.enums.DelStatus;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 购物车表
 * Created by lxu on 2018/12/11.
 */
@Entity
@Table(name = HappymallConstant.TABLE_NAME_PREFIX + "cart")
@Where(clause = "delStatus = " + DelStatus.DEFAULT)
class Cart extends BaseModel {

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
     * 数量
     */
    @Column(name = "quantity", columnDefinition = "int(11) NOT NULL COMMENT '数量'")
    private Integer quantity;

    /**
     * 是否勾选
     */
    @Column(name = "activeStatus", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '是否勾选 0-勾选 1-未勾选'")
    private ActiveStatus activeStatus;

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

}