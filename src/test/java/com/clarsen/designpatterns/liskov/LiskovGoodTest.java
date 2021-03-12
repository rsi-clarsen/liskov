package com.clarsen.designpatterns.liskov;

import com.clarsen.designpatterns.liskov.good.model.Bicycle;
import com.clarsen.designpatterns.liskov.good.model.Car;
import com.clarsen.designpatterns.liskov.good.world.RegularRoad;
import com.clarsen.designpatterns.liskov.good.world.RoughRoad;

import org.junit.jupiter.api.Test;

public class LiskovGoodTest {
    
    @Test
    public void sendTheCar() {
        RegularRoad rd = new RegularRoad();
        Car car = new Car();
        Bicycle b = new Bicycle();
        
        car.startYourEngine();
        // b.startYourEngine(); bicycle no longer has access to start an engine

        rd.traverse(car);
        rd.traverse(b);
    }

    @Test
    public void traverseTheRoughRoad() {
        RoughRoad rd = new RoughRoad();
        // Bicycle b = new Bicycle();
        Car c = new Car();

        // rd.traverse(b); cant send a non-motorized vehicle down the rough road
        rd.traverse(c);
    }
}

