package com.xul.happymall.portal.domain

import com.xul.happymall.base.enums.ActiveStatus

/**
 * 分类表
 * Created by lxu on 2018/12/11.
 */
class Category {

    /**
     * 父类别id 当id=0时说明是根节点, 一级类别
     */
    private Integer parentId

    /**
     * 分类名称
     */
    private String name

    /**
     * 是否生效
     */
    private ActiveStatus activeStatus

    /**
     * 排序编号,同类展示顺序,数值相等则自然排序
     */
    private Integer sortOrder

    @Override
    String toString() {
        return "Category{" +
                "parentId=" + parentId +
                ", name='" + name + '\'' +
                ", activeStatus=" + activeStatus +
                ", sortOrder=" + sortOrder +
                '}'
    }
}