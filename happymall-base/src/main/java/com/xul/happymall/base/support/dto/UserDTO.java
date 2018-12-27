package com.xul.happymall.base.support.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 * Created by lxu on 2018/12/11.
 */
@ApiModel(value = "用户信息")
public class UserDTO implements Serializable {

    @ApiModelProperty(value = "用户名", name = "username", example = "admin")
    private String username;

    @ApiModelProperty(value = "密码", name = "password", example = "123456")
    private String password;

    @ApiModelProperty(value = "邮箱", name = "email", example = "xxx@163.com")
    private String email;

    @ApiModelProperty(value = "电话", name = "phone", example = "13812344321")
    private String phone;

    @ApiModelProperty(value = "找回密码问题", name = "question", example = "我的小名叫什么")
    private String question;

    @ApiModelProperty(value = "找回密码答案", name = "answer", example = "二狗")
    private String answer;

    @ApiModelProperty(value = "角色ID", name = "roleId", example = "1")
    private Integer roleId;

    @ApiModelProperty(value = "上次登录时间", name = "lastLoginTime", hidden = true)
    private Date lastLoginTime;

    @ApiModelProperty(value = "上次登录时间", name = "lastLoginTimeStr", example = "2018-12-14 08:50:20")
    private String lastLoginTimeStr;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginTimeStr() {
        return lastLoginTimeStr;
    }

    public void setLastLoginTimeStr(String lastLoginTimeStr) {
        this.lastLoginTimeStr = lastLoginTimeStr;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", roleId=" + roleId +
                ", lastLoginTime=" + lastLoginTime +
                ", lastLoginTimeStr='" + lastLoginTimeStr + '\'' +
                '}';
    }
}