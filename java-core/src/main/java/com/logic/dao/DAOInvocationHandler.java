package com.logic.dao;

import com.logic.model.SafetyCheck;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 方法调用处理接口的实现类，执行原来的方法之前或之后，添加额外的操作
 */
public class DAOInvocationHandler implements InvocationHandler {
    private Object target;

    public void setTarget(Object target){
        this.target = target;
    }
    public DAOInvocationHandler(){}

    public DAOInvocationHandler(Object target){
        this.target = target;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    /**
     *
     * @param proxy
     * @param method 方法
     * @param args 方法的参数
     * @return method方法的返回结果
     * @throws Throwable
     */
    @Override
    // TODO: 2017/7/27 proxy没有被使用。。。
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SafetyCheck util = new SafetyCheck();
        util.before();
        Object result = method.invoke(target, args);
        util.after();
        return result;
    }
}
