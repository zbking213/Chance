package com.chance.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@EnableAspectJAutoProxy默认情况下是jdk的，改成true是使用cglib
@EnableAspectJAutoProxy //使用jdk动态代理时候，代理的对象不等于源目标对象，等于目标对象的接口；使用cglib的时候相等 因为cglib是集成源目标对象
@ComponentScan("com.chance")
public class AppConfig {

}
