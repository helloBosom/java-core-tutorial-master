package com.logic.model;

class Address implements Cloneable {
    private String detail;

    public Address(String _detail) {
        detail = _detail;
    }

    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}
