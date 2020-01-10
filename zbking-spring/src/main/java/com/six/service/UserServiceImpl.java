package com.six.service;

import com.six.dao.UserDao;

public class UserServiceImpl implements UserService {
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    UserDao userDao;
//   public UserServiceImpl(UserDao userDao){
//       this.userDao = userDao;
//   }
    @Override
    public void query() {
        System.out.println("serviceMethod");
        userDao.find();

    }
}
