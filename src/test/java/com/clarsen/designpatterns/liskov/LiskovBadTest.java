package com.clarsen.designpatterns.liskov;

import com.clarsen.designpatterns.liskov.bad.Road;
import com.clarsen.designpatterns.liskov.bad.model.Bicycle;
import com.clarsen.designpatterns.liskov.bad.model.Car;

import org.junit.jupiter.api.Test;

public class LiskovBadTest {
    
    @Test
    public void sendTheCar() {
        Road rd = new Road();
        Car car = new Car();

        car.startYourEngine();

        rd.traverse(car);
    }

    @Test
    public void sendTheBicycle() {
        Road rd = new Road();
        Bicycle b = new Bicycle();

        b.startYourEngine();

        rd.traverse(b);
    }
}
