package com.chance.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//将这个类交给spring容器

@Component
//@Aspect  //声明一个切面
public class ZbkingAspectJ {
    //声明一个pointcut
    @Pointcut("execution(* com.chance.dao.*.*(..))")
    public void pointCut(){

    }

    /**
     *通知
     */
    @Before("pointCut()")
    public void before(){
        System.out.println("search之前");

    }
    @After("pointCut()")
    public void after(){
        System.out.println("search之后");
    }

}
