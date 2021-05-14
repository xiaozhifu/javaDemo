package com.example.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler<T> implements InvocationHandler {

    private final T target;

    public MyInvocationHandler(T target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK 先洗手");
        Object res = method.invoke(target, args);
        System.out.println("JDK 代理结束");
        return res;
    }

    public T getProxy(){
        return (T) Proxy.newProxyInstance(
                this.target.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(),
                this
        );
    }

}
