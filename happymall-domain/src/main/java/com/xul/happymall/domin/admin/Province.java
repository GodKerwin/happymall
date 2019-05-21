package com.xul.happymall.domin.admin;

import com.xul.happymall.domin.BaseModel;
import com.xul.happymall.support.constant.HappymallConstant;
import com.xul.happymall.support.enums.DelStatus;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 省
 * Created by lxu on 2018/12/29.
 */
@Entity
@Table(name = HappymallConstant.TABLE_NAME_PREFIX + "province")
@Where(clause = "delStatus = " + DelStatus.DEFAULT)
public class Province extends BaseModel {

    /**
     * 省编码
     */
    @Column(name = "provinceCode", columnDefinition = "char(6) NOT NULL COMMENT '省编码'")
    private String provinceCode;

    /**
     * 省名称
     */
    @Column(name = "provinceName", columnDefinition = "varchar(20) NOT NULL COMMENT '省名称'")
    private String provinceName;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
}
