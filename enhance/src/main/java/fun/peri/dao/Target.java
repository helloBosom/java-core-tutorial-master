package fun.peri.dao;

import fun.peri.service.StaticProxy;

class Target implements StaticProxy {
    @Override
    public void method() {
        System.out.println("Hello world");
    }
}
