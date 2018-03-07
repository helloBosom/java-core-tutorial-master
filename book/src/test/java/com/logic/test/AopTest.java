package com.logic.test;

import com.logic.factory.ProxyFactory;
import com.logic.service.Dog;
import com.logic.serviceimpl.GunDog;
import org.junit.Test;


public class AopTest {

    @Test
    public void proxyTest(){
        Dog gunDog = new GunDog();
        Dog proxyDog = ProxyFactory.getProxy(gunDog);
        proxyDog.info();
        proxyDog.run();

    }

}
