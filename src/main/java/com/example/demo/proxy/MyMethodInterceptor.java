package com.example.demo.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor<T> implements MethodInterceptor {

    @Override
    /**
     * 拦截被代理类中的方法
     * obj 被代理对象
     * method 被拦截的方法
     * args 方法入参
     * methodProsy 用于调用原始方法
     */
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 先洗手");
        Object res = methodProxy.invokeSuper(obj, args);
        System.out.println("cglib 代理结束");
        return res;
    }

    public T getProxy(Class<T> clazz){
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(this);
        // 创建代理类
        return (T) enhancer.create();
    }

}
