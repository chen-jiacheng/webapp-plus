package com.chenjiacheng.webapp.auth.common.annotation;

import com.chenjiacheng.webapp.auth.common.enums.WebappAuthEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by chenjiacheng on 2024/11/26 00:40
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface RequireRoles {

    WebappAuthEnum[] value();

}
