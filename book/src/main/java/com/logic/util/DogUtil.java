package com.logic.util;

/**
 * 包装目标对象的方法
 */
public class DogUtil {
    public static void before() {
        System.out.println("调用方法之前执行。。。。");
    }

    public static void after() {
        System.out.println("调用方法之后执行。。。。");
    }
}
