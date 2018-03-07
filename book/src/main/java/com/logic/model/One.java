package com.logic.model;

public class One {
    String name;
    public int age;

    public One(int _age, String _name) {
        age = _age;
        name = _name;
    }

    @Override
    public int hashCode() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        One one = (One) obj;
        return this.name.equals(one.name);
    }
}
