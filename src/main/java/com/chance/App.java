package com.chance;

import com.chance.config.AppConfig;
import com.chance.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexDao indexDao = (IndexDao) annotationConfigApplicationContext.getBean("indexDao");
        indexDao.search("狗子");
        indexDao.search();

    }
}
