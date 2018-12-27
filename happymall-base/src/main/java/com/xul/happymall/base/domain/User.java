package com.xul.happymall.base.domain;

import com.xul.happymall.base.support.constant.HappymallConstant;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户表
 * Created by lxu on 2018/12/11.
 */
@Entity
@Table(name = HappymallConstant.TABLE_NAME_PREFIX + "user")
public class User extends BaseModel {

    /**
     * 用户名
     */
    @Column(name = "username", columnDefinition = "varchar(50) NOT NULL COMMENT '用户名'")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password", columnDefinition = "varchar(50) NOT NULL COMMENT '用户密码，MD5加密'")
    private String password;

    /**
     * 邮箱
     */
    @Column(name = "email", columnDefinition = "varchar(50) DEFAULT NULL COMMENT '邮箱'")
    private String email;

    /**
     * 电话
     */
    @Column(name = "phone", columnDefinition = "varchar(20) DEFAULT NULL COMMENT '电话'")
    private String phone;

    /**
     * 找回密码问题
     */
    @Column(name = "question", columnDefinition = "varchar(100) DEFAULT NULL COMMENT '找回密码问题'")
    private String question;

    /**
     * 找回密码答案
     */
    @Column(name = "answer", columnDefinition = "varchar(100) DEFAULT NULL COMMENT '找回密码答案'")
    private String answer;

    /**
     * 角色ID
     */
    @Column(name = "roleId", columnDefinition = "int(11) NOT NULL COMMENT '角色ID'")
    private Integer roleId;

    /**
     * 上次登录时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastLoginTime", columnDefinition = "datetime NOT NULL COMMENT '上次登录时间'")
    private Date lastLoginTime;

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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", roleId=" + roleId +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}