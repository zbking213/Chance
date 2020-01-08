package com.chance.proxyi;

import com.chance.dao.UserDao;
import com.chance.dao.UserDaoImpl;

public class UserDaoLog2 implements UserDao {

    private UserDaoImpl userDao;

    public UserDaoLog2(UserDaoImpl userDao){
        this.userDao = userDao;
    }
    @Override
    public void query() {
        System.out.println("这是基于接口方式的代理");
        userDao.query();

    }
}
