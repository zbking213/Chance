package com.chance.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ChanceInvocationHandler  implements InvocationHandler {
    Object target;
    public ChanceInvocationHandler(Object target){
        this.target = target;
        }

    /**
     *
     *
     * @param proxy 代理对象
     * @param method 目标对象
     * @param args  目标对象的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy");
        Method[] declaredMethods = proxy.getClass().getDeclaredMethods();
        System.out.println(declaredMethods.toString());
        //目标对象的方法
        Object invoke = method.invoke(target);

        return invoke;
    }
}
