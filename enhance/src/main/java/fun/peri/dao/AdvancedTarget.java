package fun.peri.dao;

import fun.peri.service.StaticProxy;

class AdvancedTarget implements StaticProxy {
    StaticProxy target = new Target();
    @Override
    public void method() {
        System.out.println("before....");
        target.method();  // 调用Target类中的method方法
        System.out.println("after....");
    }
}
