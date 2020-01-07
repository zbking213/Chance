package com.chance.dao;

import org.springframework.stereotype.Repository;

@Repository
public class IndexDao {

    public void search(){
        System.out.println("search");
    }

    public void search(String name){
        System.out.println("search"+name);
    }
}
