package com.xul.happymall.base.domain;

import com.xul.happymall.base.enums.DelStatus;
import com.xul.happymall.base.support.constant.HappymallConstant;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 市
 * Created by lxu on 2018/12/29.
 */
@Entity
@Table(name = HappymallConstant.TABLE_NAME_PREFIX + "city")
@Where(clause = "delStatus = " + DelStatus.DEFAULT)
public class City extends BaseModel {

    /**
     * 省编码
     */
    @Column(name = "provinceCode", columnDefinition = "char(6) NOT NULL COMMENT '省编码'")
    private String provinceCode;

    /**
     * 市编码
     */
    @Column(name = "cityCode", columnDefinition = "char(6) NOT NULL COMMENT '市编码'")
    private String cityCode;

    /**
     * 市名称
     */
    @Column(name = "cityName", columnDefinition = "varchar(20) NOT NULL COMMENT '市名称'")
    private String cityName;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
