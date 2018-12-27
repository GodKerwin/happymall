package com.xul.happymall.base.support.constant;

/**
 * Created by lxu on 2018/12/12.
 */
public class HappymallConstant {

    //happymall表前缀
    public static final String TABLE_NAME_PREFIX = "happymall_";

    public interface Role {
        //普通用户，需要与角色表联动
        int DEFAULF_ROLE = 1;

        //超级管理员，需要与角色表联动
        int ADMINSTRATOR = 2;
    }

    public interface Token {
        //存放鉴权信息的Header名称，默认是Authorization
        String USER_TOKEN = "Authorization";

        //token重置时长(秒)
        int TOKEN_RESET_TIME = 2400;

        //token过期时长(秒)
        int TOKEN_EXPIRE_TIME = 3600;

        //存放登录用户模型Key的Request Key
        String REQUEST_CURRENT_KEY = "REQUEST_CURRENT_KEY";

        //忘记密码token前缀
        String FORGET_TOKEN_PREFIX = "ForgetToken_";
    }

    public interface CheckValidType {
        String USERNAME = "username";
        String EMAIL = "email";
    }

}
