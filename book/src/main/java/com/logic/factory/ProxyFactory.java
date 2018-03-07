package com.logic.factory;

import com.logic.serviceimpl.DogInvocationHandler;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    /**
     * 为指定的 target 生成动态代理对象
     *
     * @param target 目标对象
     * @return 代理对象
     */
    public static <T> T getProxy(T target) {
        DogInvocationHandler handler = new DogInvocationHandler();
        handler.setTarget(target);
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
    }
}
