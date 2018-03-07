package com.logic.test;

/**
 * description:
 *
 * @author liyazhou
 * @since 2017-07-14 14:45
 */

class Person{
    String name;
    int age;
    Integer attribute;

    public Person(){}
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setAttribute(Integer _attribute){
        attribute = attribute;
    }
    public void info(){
        System.out.println("non parameters");
    }

    public void info(String name){
        System.out.println("parameter, name = " + this.name);
        System.out.println("parameter, name = " + name);

    }

    public void info(String name, int age){
        System.out.println("name = " + this.name + " age = " + this.age);
        System.out.println("name = " + name + " age = " + age);
    }
}
