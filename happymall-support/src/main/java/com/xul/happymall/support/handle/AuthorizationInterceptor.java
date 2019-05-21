package com.xul.happymall.support.handle;

import com.alibaba.fastjson.JSONObject;
import com.xul.happymall.support.annotation.AuthIgnore;
import com.xul.happymall.support.constant.HappymallConstant;
import com.xul.happymall.support.enums.ExceptionEnum;
import com.xul.happymall.support.utils.RedisUtil;
import com.xul.happymall.support.utils.SpringUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by lxu on 2018/12/14.
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(AuthorizationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AuthIgnore annotation;
        RedisUtil redisUtil = SpringUtil.getBean(RedisUtil.class);
        if (handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthIgnore.class);
        } else {
            return true;
        }

        //如果有@AuthIgnore注解，则不验证token
        if (annotation != null) {
            return true;
        }

        //获取用户凭证
        String username = "";
        String token = request.getHeader(HappymallConstant.Token.USER_TOKEN);
        log.info("token is {}", token);
        if (StringUtils.isNotEmpty(token)) {
            username = (String) redisUtil.get(token);
            log.info("username is {}", username);
        }

        if (StringUtils.isNotBlank(username)) {
            Long tokeBirthTime = (Long) redisUtil.get(token + username);
            log.info("token Birth time is: {}", tokeBirthTime);
            Long diff = System.currentTimeMillis() - tokeBirthTime;
            log.info("token is exist : {} ms", diff);
            if (diff > HappymallConstant.Token.TOKEN_RESET_TIME) {
                redisUtil.expire(username, HappymallConstant.Token.TOKEN_EXPIRE_TIME);
                redisUtil.expire(token, HappymallConstant.Token.TOKEN_EXPIRE_TIME);
                log.info("Reset expire time success!");
                Long newBirthTime = System.currentTimeMillis();
                redisUtil.set(token + username, newBirthTime, HappymallConstant.Token.TOKEN_RESET_TIME);
            }
            request.setAttribute(HappymallConstant.Token.REQUEST_CURRENT_KEY, username);
            return true;
        } else {
            JSONObject jsonObject = new JSONObject();
            PrintWriter out = null;
            try {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                jsonObject.put("code", ExceptionEnum.NEED_LOGIN.getCode());
                jsonObject.put("message", ExceptionEnum.NEED_LOGIN.getMsg());
                out = response.getWriter();
                out.println(jsonObject);
                request.setAttribute(HappymallConstant.Token.REQUEST_CURRENT_KEY, null);
                return false;
            } catch (Exception e) {
                log.error(e.toString());
                throw e;
            } finally {
                if (null != out) {
                    out.flush();
                    out.close();
                }
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
