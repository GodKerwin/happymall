package com.xul.happymall.portal.domain;

import com.xul.happymall.base.domain.BaseModel;
import com.xul.happymall.base.enums.DelStatus;
import com.xul.happymall.base.support.constant.HappymallConstant;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by lxu on 2018/12/11.
 */
@Entity
@Table(name = HappymallConstant.TABLE_NAME_PREFIX + "address")
@Where(clause = "delStatus = " + DelStatus.DEFAULT)
class Address extends BaseModel {

    /**
     * 用户ID
     */
    @Column(name = "userId", columnDefinition = "int(11) NOT NULL COMMENT '用户ID'")
    private Integer userId;

    /**
     * 收货姓名
     */
    @Column(name = "receiverName", columnDefinition = "varchar(20) DEFAULT NULL COMMENT '收货姓名'")
    private String receiverName;

    /**
     * 收货固定电话
     */
    @Column(name = "receiverPhone", columnDefinition = "varchar(20) DEFAULT NULL COMMENT '收货固定电话'")
    private String receiverPhone;

    /**
     * 收货移动电话
     */
    @Column(name = "receiverMobile", columnDefinition = "varchar(20) DEFAULT NULL COMMENT '收货移动电话'")
    private String receiverMobile;

    /**
     * 省份编码
     */
    @Column(name = "receiverProvinceCode", columnDefinition = "int(11) DEFAULT NULL COMMENT '省份编码'")
    private Integer receiverProvinceCode;

    /**
     * 城市编码
     */
    @Column(name = "receiverCityCode", columnDefinition = "int(11) DEFAULT NULL COMMENT '城市编码'")
    private Integer receiverCityCode;

    /**
     * 区/县编码
     */
    @Column(name = "receiverDistrictCode", columnDefinition = "int(11) DEFAULT NULL COMMENT '区/县编码'")
    private Integer receiverDistrictCode;

    /**
     * 详细地址
     */
    @Column(name = "receiverAddress", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '详细地址'")
    private String receiverAddress;

    /**
     * 邮编
     */
    @Column(name = "receiverZip", columnDefinition = "char(6) DEFAULT NULL COMMENT '邮编'")
    private String receiverZip;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public Integer getReceiverProvinceCode() {
        return receiverProvinceCode;
    }

    public void setReceiverProvinceCode(Integer receiverProvinceCode) {
        this.receiverProvinceCode = receiverProvinceCode;
    }

    public Integer getReceiverCityCode() {
        return receiverCityCode;
    }

    public void setReceiverCityCode(Integer receiverCityCode) {
        this.receiverCityCode = receiverCityCode;
    }

    public Integer getReceiverDistrictCode() {
        return receiverDistrictCode;
    }

    public void setReceiverDistrictCode(Integer receiverDistrictCode) {
        this.receiverDistrictCode = receiverDistrictCode;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

}