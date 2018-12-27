package com.xul.happymall.portal.domain;

import com.xul.happymall.base.domain.BaseModel;
import com.xul.happymall.base.enums.ActiveStatus;
import com.xul.happymall.base.enums.DelStatus;
import com.xul.happymall.base.support.constant.HappymallConstant;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 商品表
 * Created by lxu on 2018/12/11.
 */
@Entity
@Table(name = HappymallConstant.TABLE_NAME_PREFIX + "product")
@Where(clause = "delStatus = " + DelStatus.DEFAULT)
class Product extends BaseModel {

    /**
     * 分类ID
     */
    @Column(name = "categoryId", columnDefinition = "int(11) NOT NULL COMMENT '分类ID'")
    private Integer categoryId;

    /**
     * 商品名称
     */
    @Column(name = "name", columnDefinition = "varchar(100) DEFAULT NULL COMMENT '商品名称'")
    private String name;

    /**
     * 商品副标题
     */
    @Column(name = "subtitle", columnDefinition = "varchar(200) DEFAULT NULL COMMENT '商品副标题'")
    private String subtitle;

    /**
     * 产品主图,url相对地址
     */
    @Column(name = "mainImage", columnDefinition = "varchar(500) DEFAULT NULL COMMENT '产品主图,url相对地址'")
    private String mainImage;

    /**
     * 图片地址,json格式,扩展用
     */
    @Column(name = "subImages", columnDefinition = "text DEFAULT NULL COMMENT '图片地址,json格式,扩展用'")
    private String subImages;

    /**
     * 商品详情
     */
    @Column(name = "detail", columnDefinition = "text DEFAULT NULL COMMENT '商品详情'")
    private String detail;

    /**
     * 价格,单位-元保留两位小数
     */
    @Column(name = "price", columnDefinition = "decimal(20,2) NOT NULL COMMENT '价格,单位-元保留两位小数'")
    private BigDecimal price;

    /**
     * 库存数量
     */
    @Column(name = "stock", columnDefinition = "int(11) NOT NULL COMMENT '库存数量'")
    private Integer stock;

    /**
     * 生效状态
     */
    @Column(name = "activeStatus", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '生效状态 0-生效 1-失效'")
    private ActiveStatus activeStatus;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getSubImages() {
        return subImages;
    }

    public void setSubImages(String subImages) {
        this.subImages = subImages;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
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
                '}';
    }
}