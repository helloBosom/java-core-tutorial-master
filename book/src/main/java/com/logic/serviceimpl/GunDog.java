package com.logic.serviceimpl;

import com.logic.service.Dog;

public class GunDog implements Dog {

    @Override
    public void info() {
        System.out.println("i am a gun dog.");
    }

    @Override
    public void run() {
        System.out.println("gun dog run fast.");
    }
}
