package com.example.demo.proxy;

public class Test {

    public static void main(String[] args) {

        Action actionJDK = new MyInvocationHandler<Action>(new ActionImpl()).getProxy();
        actionJDK.eat();

        System.out.println("-----------------------------------");

        ActionImpl actionCglib = new MyMethodInterceptor<ActionImpl>().getProxy(ActionImpl.class);
        actionCglib.eat();

        System.out.println("-----------------------------------");

        ActionProxy actionProxy = new ActionProxy(new ActionImpl());
        actionProxy.eat();

    }

}
