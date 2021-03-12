package com.clarsen.designpatterns.liskov.bad.model;

public class Car extends Vehicle {

    @Override
    public void startYourEngine() {
        super.startYourEngine();
    }
}
