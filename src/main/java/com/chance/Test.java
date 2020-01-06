package com.chance;

import com.chance.config.AppConfig;
import com.chance.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexDao indexDao = (IndexDao) annotationConfigApplicationContext.getBean("indexDao");
        indexDao.search();

    }
}
