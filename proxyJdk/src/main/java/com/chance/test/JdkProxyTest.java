package com.chance.test;

import com.chance.dao.UserDao;
import com.chance.dao.UserDaoImpl;
import com.chance.handler.ChanceInvocationHandler;

import java.lang.reflect.Proxy;

public class JdkProxyTest {

    public static void main(String[] args) {

        UserDao userDao = (UserDao) Proxy.newProxyInstance(JdkProxyTest.class.getClassLoader(), new Class[]{UserDao.class},
                new ChanceInvocationHandler(new UserDaoImpl()));
        userDao.query();
        userDao.eat();
    }
}
