package com.logic.model;

import java.io.Serializable;

/**
 * 自定义类 School
 */
public class School implements Cloneable, Serializable {
    String name;
    public School(String name){
        this.name = name;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
