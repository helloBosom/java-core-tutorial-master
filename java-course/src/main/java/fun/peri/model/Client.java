package fun.peri.model;

import org.junit.Test;

public class Client {

    @Test
    public void testCarMove() {
        Movable car = new Car();
        car.move();
    }


    @Test
    public void testEnhanceCarMove() {
        Movable car = new EnhanceCarByExtends();
        car.move();
    }

    @Test
    public void testEnhanceCarByCombination() {
        Movable car = new Car();
        Movable enhanceCar = new EnhanceCarByCombination(car);
        enhanceCar.move();
    }
}
