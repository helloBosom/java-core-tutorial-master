package com.logic.model;

import com.logic.annotation.Description;

@Description("I am a class annotation.")
public class Child implements com.logic.service.Person {
    @Description("I am a method annotation, name = zz")
    @Override
    public String name() {
        return null;
    }

    @Description("i am a method annotation, age = 18")
    @Override
    public int age() {
        return 0;
    }
}
