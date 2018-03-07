package com.logic.dao;

import com.logic.service.DAO;

/**
 * 接口的实现类，它的实例需要被代理
 * @param <T>
 */
public class StudentDAO<T> implements DAO<T> {
    @Override
    public int save(T t) {
        printCurrentMethodName();
        System.out.println("save data....");
        return 0;
    }

    @Override
    public T remove(String id) {
        printCurrentMethodName();
        System.out.println("delete data....");
        return null;
    }

    private void printCurrentMethodName(){
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        System.out.println(methodName + " starts running....");
    }
}
