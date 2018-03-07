package com.logic.factory;

import com.logic.dao.DAOInvocationHandler;

import java.lang.reflect.Proxy;

public class DaoProxyFactory{
    public static Object getProxyObject(Object target){
        DAOInvocationHandler handler = new DAOInvocationHandler();
        handler.setTarget(target);
        // 加载被代理对象的类加载器，被代理的对象的接口，和方法调用处理接口的实例传递给Proxy
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
    }
}
