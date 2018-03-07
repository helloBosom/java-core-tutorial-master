package com.logic.model;

/**
 * 提供增强操作的类
 */
public class SafetyCheck {
    public void before() {
        System.out.println("方法执行之前....安全检查....");
    }

    public void after() {
        System.out.println("方法执行之后....安全检查....");
    }
}
