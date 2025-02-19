package com.chenjiacheng.webapp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.hibernate.validator.HibernateValidator;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

@Aspect
@Component
public class ValidationAspect {
    private static final Validator validator;

    static {
        validator = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory()
                .getValidator();
    }

    // Define a pointcut for methods that need validation
    @Pointcut("execution(public * com.chenjiacheng.webapp.controller..*.*(..))")
    public void validationPointcut() {}

    // @Pointcut("@annotation(javax.validation.Valid)")
    // public void validationPointcut() {}

    // Around advice to perform validation
    @Around("validationPointcut()")
    public Object validate(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            Set<ConstraintViolation<Object>> violations = validator.validate(arg);
            if (!violations.isEmpty()) {
                String message = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", "));
                throw new IllegalArgumentException(message);
            }
        }
        return joinPoint.proceed();
    }
}