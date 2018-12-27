package com.xul.happymall.base.web;

import com.xul.happymall.base.enums.DelStatus;
import com.xul.happymall.base.service.IUserService;
import com.xul.happymall.base.support.annotation.AuthIgnore;
import com.xul.happymall.base.support.constant.HappymallConstant;
import com.xul.happymall.base.support.dto.ResponseDTO;
import com.xul.happymall.base.support.dto.UserDTO;
import com.xul.happymall.base.support.exception.HappymallSystemException;
import com.xul.happymall.base.support.utils.MD5Util;
import com.xul.happymall.base.support.utils.RedisUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lxu on 2018/12/11.
 */
@Api(tags = "用户模块", description = "部分接口需要在header放入token")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private RedisUtil redisUtil;

    @AuthIgnore
    @ApiOperation(value = "用户登录接口", notes = "会将token存入redis")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "string", paramType = "query", required = true, example = "admin"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string", paramType = "query", required = true, example = "111111")
    })
    @PostMapping(value = "login")
    public ResponseDTO login(@RequestParam String username, @RequestParam String password) {
        ResponseDTO result;
        try {
            userService.login(username, password);
            long now = System.currentTimeMillis();
            //token生成规则：用户名+密码+时间戳
            String token = MD5Util.encode(username + password + now);
            redisUtil.set(token, username, HappymallConstant.Token.TOKEN_EXPIRE_TIME);
            redisUtil.set(username, token, HappymallConstant.Token.TOKEN_EXPIRE_TIME);
            redisUtil.set(token + username, now, HappymallConstant.Token.TOKEN_EXPIRE_TIME);
            result = ResponseDTO.success(token);
        } catch (HappymallSystemException e) {
            result = ResponseDTO.error(e);
        }
        return result;
    }

    @ApiOperation(value = "用户登出接口")
    @PostMapping(value = "logout")
    public ResponseDTO logout(@ApiIgnore HttpServletRequest request) {
        String token = request.getHeader(HappymallConstant.Token.USER_TOKEN);
        String username = (String) request.getAttribute(HappymallConstant.Token.REQUEST_CURRENT_KEY);
        redisUtil.del(username, token, token + username);
        return ResponseDTO.success();
    }

    @AuthIgnore
    @ApiOperation(value = "注册接口")
    @PostMapping(value = "register")
    public ResponseDTO register(@ApiParam(name = "user", value = "用户信息", required = true) @RequestBody UserDTO user) {
        ResponseDTO result;
        try {
            userService.register(user);
            result = ResponseDTO.success();
        } catch (HappymallSystemException e) {
            result = ResponseDTO.error(e);
        }
        return result;
    }

    @AuthIgnore
    @ApiOperation(value = "校验用户名或邮箱是否存在，存在报错")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "field", value = "校验字段", dataType = "string", paramType = "query", required = true, example = "admin"),
            @ApiImplicitParam(name = "type", value = "检验类型", dataType = "string", paramType = "query", required = true, example = "username")
    })
    @PostMapping(value = "checkExist")
    public ResponseDTO checkExist(@RequestParam String field,
                                  @RequestParam String type) {
        ResponseDTO result;
        try {
            userService.checkExist(field, type);
            result = ResponseDTO.success();
        } catch (HappymallSystemException e) {
            result = ResponseDTO.error(e);
        }
        return result;
    }

    @AuthIgnore
    @ApiOperation(value = "校验用户名或邮箱是否存在，不存在报错")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "field", value = "校验字段", dataType = "string", paramType = "query", required = true, example = "admin"),
            @ApiImplicitParam(name = "type", value = "检验类型", dataType = "string", paramType = "query", required = true, example = "username")
    })
    @PostMapping(value = "checkNotExist")
    public ResponseDTO checkNotExist(@RequestParam String field,
                                     @RequestParam String type) {
        ResponseDTO result;
        try {
            userService.checkNotExist(field, type);
            result = ResponseDTO.success();
        } catch (HappymallSystemException e) {
            result = ResponseDTO.error(e);
        }
        return result;
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping(value = "getUserInfo")
    public ResponseDTO getUserInfo(@ApiIgnore HttpServletRequest request) {
        String username = (String) request.getAttribute(HappymallConstant.Token.REQUEST_CURRENT_KEY);
        return ResponseDTO.success(userService.getUserInfo(username));
    }

    @AuthIgnore
    @ApiOperation(value = "忘记密码后查询找回密码问题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "string", paramType = "query", required = true, example = "admin"),
    })
    @GetMapping(value = "forgetGetQuestion")
    public ResponseDTO forgetGetQuestion(@RequestParam String username) {
        ResponseDTO result;
        try {
            result = ResponseDTO.success(userService.selectQuestion(username));
        } catch (HappymallSystemException e) {
            result = ResponseDTO.error(e);
        }
        return result;
    }

    @AuthIgnore
    @ApiOperation(value = "忘记密码后校验找回密码答案")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "string", paramType = "query", required = true, example = "admin"),
            @ApiImplicitParam(name = "question", value = "找回密码问题", dataType = "string", paramType = "query", required = true, example = "我的小名叫什么"),
            @ApiImplicitParam(name = "answer", value = "找回密码答案", dataType = "string", paramType = "query", required = true, example = "二狗")
    })
    @PostMapping(value = "forgetCheckAnswer")
    public ResponseDTO forgetCheckAnswer(@RequestParam String username,
                                         @RequestParam String question,
                                         @RequestParam String answer) {
        ResponseDTO result;
        try {
            result = ResponseDTO.success(userService.checkAnswer(username, question, answer));
        } catch (HappymallSystemException e) {
            result = ResponseDTO.error(e);
        }
        return result;
    }

    @AuthIgnore
    @ApiOperation(value = "忘记密码后重置密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "string", paramType = "query", required = true, example = "admin"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", dataType = "string", paramType = "query", required = true, example = "123456"),
            @ApiImplicitParam(name = "forgetToken", value = "忘记密码令牌", dataType = "string", paramType = "query", required = true, example = "c1ec17bb-5b5a-4d5c-82d9-2529726a884b"),
    })
    @PostMapping(value = "forgetResetPassword")
    public ResponseDTO forgetResetPassword(@RequestParam String username,
                                           @RequestParam String newPassword,
                                           @RequestParam String forgetToken) {
        ResponseDTO result;
        try {
            userService.forgetResetPassword(username, newPassword, forgetToken);
            result = ResponseDTO.success();
        } catch (HappymallSystemException e) {
            result = ResponseDTO.error(e);
        }
        return result;
    }

    @ApiOperation(value = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", dataType = "string", paramType = "query", required = true, example = "111111"),
            @ApiImplicitParam(name = "newPassword", value = "新密码", dataType = "string", paramType = "query", required = true, example = "123456"),
    })
    @PostMapping(value = "updatePassword")
    public ResponseDTO updatePassword(@ApiIgnore HttpServletRequest request,
                                      @RequestParam String oldPassword,
                                      @RequestParam String newPassword) {
        String username = (String) request.getAttribute(HappymallConstant.Token.REQUEST_CURRENT_KEY);
        ResponseDTO result;
        try {
            userService.updatePassword(username, oldPassword, newPassword);
            result = ResponseDTO.success();
        } catch (HappymallSystemException e) {
            result = ResponseDTO.error(e);
        }
        return result;
    }

    @ApiOperation(value = "修改个人信息")
    @PostMapping(value = "updateInformation")
    public ResponseDTO updateInformation(@ApiIgnore HttpServletRequest request,
                                         @ApiParam(name = "user", value = "用户信息", required = true) @RequestBody UserDTO user) {
        String username = (String) request.getAttribute(HappymallConstant.Token.REQUEST_CURRENT_KEY);
        ResponseDTO result;
        try {
            user.setUsername(username);
            userService.updateInformation(user);
            result = ResponseDTO.success();
        } catch (HappymallSystemException e) {
            result = ResponseDTO.error(e);
        }
        return result;
    }

    @ApiOperation(value = "校验是否是管理员")
    @PostMapping(value = "checkAdminRole")
    public ResponseDTO checkAdminRole(@ApiIgnore HttpServletRequest request) {
        String username = (String) request.getAttribute(HappymallConstant.Token.REQUEST_CURRENT_KEY);
        ResponseDTO result;
        if (userService.getUserInfo(username).getRoleId() == HappymallConstant.Role.ADMINSTRATOR) {
            result = ResponseDTO.success(true);
        } else {
            result = ResponseDTO.success(false);
        }
        return result;
    }

}
