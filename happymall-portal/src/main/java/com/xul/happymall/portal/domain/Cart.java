package com.xul.happymall.portal.domain

import com.xul.happymall.base.domain.BaseModel
import com.xul.happymall.base.enums.ActiveStatus

/**
 * 购物车表
 * Created by lxu on 2018/12/11.
 */
class Cart extends BaseModel {

    /**
     * 用户ID
     */
    private Integer userId

    /**
     * 商品ID
     */
    private Integer productId

    /**
     * 数量
     */
    private Integer quantity

    /**
     * 是否勾选
     */
    private ActiveStatus activeStatus

    @Override
    String toString() {
        return "Cart{" +
                "userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", activeStatus=" + activeStatus +
                '}'
    }
}