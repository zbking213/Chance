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

    //@See https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#aop-pointcuts
    //声明一个pointcut
    //*  execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern)
    //                throws-pattern?)
    @Pointcut("execution(* com.chance.dao.*.*(..))")
    public void pointCutWithExecution(){

    }

    /**
     * See https://shimo.im/docs/Nj0bcFUy3SYyYnbI/read
     * execution和within的区别？
     *  execution的最小粒度到方法的参数，返回值，
     *  within只能到类
     */
    @Pointcut("within(com.chance.dao.*)")
    public void pointCutWithin(){

    }

    //给方法加参数的匹配
    @Pointcut("execution(* com.chance.dao.*.*(String ))")
    public void poinctCutWithExecution2(){

    }
    //args匹配的是类型
    @Pointcut("args(java.lang.Integer)")
    public void pointArgs(){

    }
    //this表示代理的对象；
    //target代表目标对象;
    public void pointThis(){

    }

    /**
     *通知
     */
//    @Before("poinctCutWithExecution2()")
//    @B
//    efore("poinctCutWithExecution2()&&!pointArgs()")
   @Before("pointCutWithExecution()")
    public void before(){

        System.out.println("search之前");

    }

    //环绕通知



}
