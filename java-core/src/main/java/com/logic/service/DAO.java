package com.logic.service;

/**
 * 该接口的实现类的实例需要被代理
 * @param <T>
 */
public interface DAO<T>{
    int save(T t);
    T remove(String id);
}
