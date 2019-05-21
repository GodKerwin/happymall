package com.xul.happymall.domin.admin;

import com.xul.happymall.domin.BaseModel;
import com.xul.happymall.support.constant.HappymallConstant;
import com.xul.happymall.support.enums.DelStatus;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 区/县
 * Created by lxu on 2018/12/29.
 */
@Entity
@Table(name = HappymallConstant.TABLE_NAME_PREFIX + "district")
@Where(clause = "delStatus = " + DelStatus.DEFAULT)
public class District extends BaseModel {

    /**
     * 市编码
     */
    @Column(name = "cityCode", columnDefinition = "char(6) NOT NULL COMMENT '市编码'")
    private String cityCode;

    /**
     * 区/县编码
     */
    @Column(name = "districtCode", columnDefinition = "char(6) NOT NULL COMMENT '区/县编码'")
    private String districtCode;

    /**
     * 区/县名称
     */
    @Column(name = "districtName", columnDefinition = "varchar(20) NOT NULL COMMENT '区/县名称'")
    private String districtName;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
