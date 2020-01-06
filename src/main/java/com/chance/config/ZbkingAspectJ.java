package com.chance.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
//将这个类交给spring容器

@Component
@Aspect  //声明一个切面
public class ZbkingAspectJ {
    //声明一个pointcut
    @Pointcut("execution(* com.chance.dao.*.*(..))")
    public void pointCutWithExecution(){

    }

    @Pointcut("within(com.chance.dao.*)")
    public void pointCutWithin(){

    }



    /**
     *通知
     */
    @Before("pointCutWithin()")
    public void before(){
        System.out.println("search之前");

    }

}
