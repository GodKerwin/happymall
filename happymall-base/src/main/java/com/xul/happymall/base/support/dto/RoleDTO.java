package com.xul.happymall.base.support.dto;

import com.xul.happymall.base.enums.ActiveStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by lxu on 2018/12/14.
 */
@ApiModel(value = "角色信息")
public class RoleDTO implements Serializable {

    @ApiModelProperty(value = "角色名称", name = "name", example = "普通用户")
    private String name;

    @ApiModelProperty(value = "生效状态 0-生效 1-失效", name = "activeStatus", example = "0")
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
        return "RoleDTO{" +
                "name='" + name + '\'' +
                ", activeStatus=" + activeStatus +
                '}';
    }
}
