package com.xul.happymall.service.admin;

import com.xul.happymall.support.dto.admin.UserDTO;
import com.xul.happymall.support.exception.HappymallSystemException;

/**
 * Created by lxu on 2018/12/12.
 */
public interface IUserService {

    /**
     * 登录
     */
    void login(String username, String password) throws HappymallSystemException;

    /**
     * 注册
     */
    void register(UserDTO user) throws HappymallSystemException;

    /**
     * 校验用户名或邮箱是否存在，存在报错 type可传username、email
     */
    void checkExist(String field, String type) throws HappymallSystemException;

    /**
     * 校验用户名或邮箱是否存在，不存在报错 type可传username、email
     */
    void checkNotExist(String field, String type);

    /**
     * 获取用户信息
     */
    UserDTO getUserInfo(String username);

    /**
     * 查询找回密码问题
     */
    String selectQuestion(String username) throws HappymallSystemException;

    /**
     * 校验找回密码答案
     */
    String checkAnswer(String username, String question, String answer) throws HappymallSystemException;

    /**
     * 修改密码
     */
    void forgetResetPassword(String username, String newPassword, String forgetToken);

    /**
     * 修改密码
     */
    void updatePassword(String username, String oldPassword, String newPassword);

    /**
     * 修改个人信息
     */
    void updateInformation(UserDTO user);
}