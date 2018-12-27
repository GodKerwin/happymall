package com.xul.happymall.base.domain;

import com.xul.happymall.base.enums.ActiveStatus;
import com.xul.happymall.base.enums.DelStatus;
import com.xul.happymall.base.support.constant.HappymallConstant;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色表
 * Created by lxu on 2018/12/12.
 */
@Entity
@Table(name = HappymallConstant.TABLE_NAME_PREFIX + "role")
@Where(clause = "delStatus = " + DelStatus.DEFAULT + " and activeStatus = " + ActiveStatus.DEFAULT)
public class Role extends BaseModel {

    /**
     * 角色名称
     */
    @Column(name = "name", columnDefinition = "varchar(50) NOT NULL COMMENT '角色名称'")
    private String name;

    /**
     * 生效状态
     */
    @Column(name = "activeStatus", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '生效状态 0-生效 1-失效'")
    private ActiveStatus activeStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(ActiveStatus activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", activeStatus=" + activeStatus +
                '}';
    }
}
