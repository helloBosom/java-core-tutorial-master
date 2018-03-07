package com.logic.serviceimpl;

import com.logic.util.DogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DogInvocationHandler implements InvocationHandler {
    private Object target;  // 被代理的对象

    public void setTarget(Object _target) {
        target = _target;
    }

    /**
     * InvocationHandler的invoke方法
     *
     * @param proxy  被代理的对象
     * @param method invoke中要执行的方法
     * @param args   method方法中的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtil.before();
        Object result = method.invoke(target, args);  // Method 的 invoke 方法
        DogUtil.after();
        return result;
    }
}
