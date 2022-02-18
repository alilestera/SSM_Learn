package com.alilestera.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Alilestera
 * @date 2/17/2022
 */
@Aspect
@Component
public class MyAspect {

    //定义切点
    @Pointcut("execution(* com.alilestera.service..*.*(..))")
    public void pt() {
    }

    //进行增强
    @Before("pt()")
    public void before() {
        System.out.println("before");
    }
}
