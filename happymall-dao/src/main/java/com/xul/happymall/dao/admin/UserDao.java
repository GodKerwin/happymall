package com.xul.happymall.dao.admin;

import com.xul.happymall.domin.admin.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by lxu on 2018/12/26.
 */
@Mapper
public interface UserDao {

    /**
     * 修改密码
     */
    int updatePasswordByUsername(@Param("password") String password,
                                 @Param("username") String username);

    /**
     * 更新最后登录时间
     */
    int updateLastLoginTimeByUsername(@Param("lastLoginTime") Date lastLoginTime,
                                      @Param("username") String username);

    /**
     * 更新个人信息
     */
    int updateInformation(User user);
}
