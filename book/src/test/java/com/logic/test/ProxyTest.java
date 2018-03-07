package com.logic.test;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;


public class ProxyTest {

    @Test
    public void invocationHandlerTest(){
        // 创建一个 InvocationHandler 对象
        InvocationHandler handler = new MyInvocationHandler();
        // 使用指定的InvocationHandler生成一个动态代理对象
        Student student = (Student) Proxy.newProxyInstance(Student.class.getClassLoader(),
                new Class[]{Student.class}, handler);
        student.walk();
        student.sayHello("zz");
    }
}
