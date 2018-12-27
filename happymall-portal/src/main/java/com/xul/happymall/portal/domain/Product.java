package com.xul.happymall.portal.domain

import com.xul.happymall.base.enums.ActiveStatus

/**
 * 商品表
 * Created by lxu on 2018/12/11.
 */
class Product {

    /**
     * 分类ID
     */
    private Integer categoryId

    /**
     * 商品名称
     */
    private String name

    /**
     * 商品副标题
     */
    private String subtitle

    /**
     * 产品主图,url相对地址
     */
    private String mainImage

    /**
     * 图片地址,json格式,扩展用
     */
    private String subImages

    /**
     * 商品详情
     */
    private String detail

    /**
     * 价格,单位-元保留两位小数
     */
    private BigDecimal price

    /**
     * 库存数量
     */
    private Integer stock

    /**
     * 商品状态
     */
    private ActiveStatus activeStatus

    @Override
    String toString() {
        return "Product{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", mainImage='" + mainImage + '\'' +
                ", subImages='" + subImages + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", activeStatus=" + activeStatus +
                '}'
    }
}