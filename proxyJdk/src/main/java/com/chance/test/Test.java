package com.chance.test;

import com.chance.dao.UserDao;
import com.chance.dao.UserDaoImpl;
import com.chance.proxy.ProxyUtils;
import com.chance.proxye.UserDaoLog;
import com.chance.proxyi.UserDaoLog2;


public class Test {


    public static void main(String[] args) {
//        UserDaoImpl userDao = new UserDaoImpl();
////        UserDaoImpl userDao = new UserDaoImpl();
////            userDao.query();
//        UserDaoLog2 userDaoLog = new UserDaoLog2(userDao);
//        userDaoLog.query();
        /**
         * java开发中两个重要原则，开闭，单一
         * 现在要给这个方法加日志？怎么加，加到哪？
         *1,继承需要加日志的类
         */
        UserDao userDao = new UserDaoImpl();
        Object o = ProxyUtils.newInstance(userDao.class);
    }

}
