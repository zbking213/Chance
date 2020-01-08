package com.chance.proxye;

import com.chance.dao.UserDaoImpl;

public class UserDaoLog extends UserDaoImpl {

    public void log(){
        System.out.println("记录日志");
    }
    @Override
    public void query() {
        //重写父类的方法，在这之前加入log方法
        log();
        super.query();
    }

}
