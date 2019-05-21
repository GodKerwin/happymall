package com.xul.happymall.support.annotation;

import java.lang.annotation.*;

/**
 * Created by lxu on 2018/12/14.
 * 加上该注解的类http请求时需要进行token鉴权
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthIgnore {

}


