package com.six;

import com.six.service.UserService;
import com.six.util.BeanFactory;

public class AppTest {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory("zbking.xml");
       UserService userService = (UserService) beanFactory.getBean("userService");
       userService.query();

    }
}
