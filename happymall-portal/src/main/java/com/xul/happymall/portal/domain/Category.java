package com.xul.happymall.portal.domain;

import com.xul.happymall.base.domain.BaseModel;
import com.xul.happymall.base.enums.ActiveStatus;
import com.xul.happymall.base.enums.DelStatus;
import com.xul.happymall.base.support.constant.HappymallConstant;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 分类表
 * Created by lxu on 2018/12/11.
 */
@Entity
@Table(name = HappymallConstant.TABLE_NAME_PREFIX + "category")
@Where(clause = "delStatus = " + DelStatus.DEFAULT)
class Category extends BaseModel {

    /**
     * 父类别id 当id=0时说明是根节点, 一级类别
     */
    @Column(name = "parentId", columnDefinition = "int(11) NOT NULL COMMENT '父类别id 当id=0时说明是根节点, 一级类别'")
    private Integer parentId;

    /**
     * 分类名称
     */
    @Column(name = "name", columnDefinition = "varchar(20) NOT NULL COMMENT '分类名称'")
    private String name;

    /**
     * 是否生效
     */
    @Column(name = "activeStatus", columnDefinition = "tinyint(1) DEFAULT '0' COMMENT '生效状态 0-生效 1-失效'")
    private ActiveStatus activeStatus;

    /**
     * 排序编号,同类展示顺序,数值相等则自然排序
     */
    @Column(name = "sortOrder", columnDefinition = "int(4) NOT NULL COMMENT '排序编号,同类展示顺序,数值相等则自然排序'")
    private Integer sortOrder;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

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

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "Category{" +
                "parentId=" + parentId +
                ", name='" + name + '\'' +
                ", activeStatus=" + activeStatus +
                ", sortOrder=" + sortOrder +
                '}';
    }
}