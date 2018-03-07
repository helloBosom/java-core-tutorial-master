package fun.peri.cglibproxy;

import org.junit.Test;

public class CglibProxyTest {

    @Test
    public void testMove() {
        CglibProxy cglibProxy = new CglibProxy();
        Train train = (Train) cglibProxy.getProxy(Train.class);
        train.move();
    }
}
