package com.chenjiacheng.webapp.aop;

import com.chenjiacheng.webapp.common.annotation.RequireRoles;
import com.chenjiacheng.webapp.common.config.WebappAuthConfig;
import com.chenjiacheng.webapp.common.enums.WebappAuthEnum;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;
import java.util.*;

/**
 * Created by chenjiacheng on 2024/11/26 00:47
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Aspect
@Component
public class WebappAuthAspect {


    @Autowired
    private WebappAuthConfig webappAuthConfig;

    @Pointcut("@annotation(com.chenjiacheng.webapp.common.annotation.RequireRoles)")
    public void requireRoles() {}

    // 前置通知，用于检查用户角色
    @Before("requireRoles()")
    public void checkRoles(JoinPoint joinPoint) throws AccessDeniedException {
        // 获取方法上的RequireRoles注解
        RequireRoles requireRoles = (RequireRoles) joinPoint.getSignature().getDeclaringType().getAnnotation(RequireRoles.class);
        if (requireRoles == null) {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            requireRoles = methodSignature.getMethod().getAnnotation(RequireRoles.class);
        }

        // 方法需要的权限
        Set<String> requireRolesSet = getRequireRoles(requireRoles);

        // 用户当前权限
        String username = (String) joinPoint.getArgs()[0];
        List<String> currentUserRoles = getRoles(username);

        // 检查用户是否具有所需的角色
        boolean hasRequiredRole = false;
        for (String role : requireRolesSet) {
            if (currentUserRoles.contains(role)) {
                hasRequiredRole = true;
                break;
            }
        }
        if (!hasRequiredRole) {
            throw new AccessDeniedException("Insufficient permissions");
        }
    }

    private Set<String> getRequireRoles(RequireRoles requireRoles) {
        WebappAuthEnum[] enums = requireRoles.value();
        Set<String> requireRolesSet = new HashSet<>();
        for (WebappAuthEnum authEnum : enums) {
            String roleCode = webappAuthConfig.getRids().get(authEnum.getCode());
            requireRolesSet.add(roleCode);
        }
        return requireRolesSet;
    }


    public static final Map<String,List<String>> userRoles = new HashMap<>();
    static {
        userRoles.put("zhangsan",Arrays.asList("H000001","H000002"));
        userRoles.put("lisi",Arrays.asList("H000001"));
    }
    private List<String> getRoles(String username) {
        return userRoles.get(username);
    }

}
