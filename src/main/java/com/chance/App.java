package com.chance;

import com.chance.config.AppConfig;
import com.chance.dao.Dao;
import com.chance.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexDao indexDao = (IndexDao) annotationConfigApplicationContext.getBean("indexDao");
        indexDao.search("狗子");
        System.out.println("----------------");
        indexDao.search();

//        Class<?>[] interfaces = new Class[]{Dao.class};
//        byte[] zbkings = ProxyGenerator.generateProxyClass("zbking", interfaces);
//        File file = new File("d:\\zbking.class");
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        try {
//
//            fileOutputStream.write(zbkings);
//            fileOutputStream.flush();
//            fileOutputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
