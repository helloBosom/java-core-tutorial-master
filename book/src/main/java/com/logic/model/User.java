package com.logic.model;

class User implements Cloneable {
    private int age;
    Address address;

    public User(int _age) {
        age = _age;
        address = new Address("沈阳浑南");
    }

    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
