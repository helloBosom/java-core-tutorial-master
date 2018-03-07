package com.logic.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

class MyInvocationHandler implements InvocationHandler {

    /**
     * 执行动态代理类的所有方法时，都会被替换执行如下的invoke方法
     * @param proxy 动态代理对象
     * @param method 正在执行的方法
     * @param args 调用目标方法时，传入的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-------------正在执行的方法：" + method);
        if (args != null){
            System.out.print("-------------调用目标方法时，传入的实参：");
            System.out.println(Arrays.toString(args));
        }
        else
            System.out.println("调用该方法时，没有传入实参！");
        return null;
    }
}
