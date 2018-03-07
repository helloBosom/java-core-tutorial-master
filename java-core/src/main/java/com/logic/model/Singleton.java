package com.logic.model;

class Singleton{
    private final static Singleton INSTANCE;
    static {
        INSTANCE = new Singleton();
    }
}
