package com.example.demo.proxy;

public class ActionProxy implements Action{

    private final Action action;

    public ActionProxy(Action action){
        this.action = action;
    }

    @Override
    public void eat() {
        System.out.println("静态代理 先洗手");
        action.eat();
        System.out.println("静态代理 代理结束");
    }

}
