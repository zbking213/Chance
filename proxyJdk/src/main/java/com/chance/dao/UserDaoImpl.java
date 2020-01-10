package com.chance.dao;

public class UserDaoImpl implements UserDao {


    @Override
    public void query() {
        System.out.println("假装查询数据库");
    }

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}
