package com.clarsen.designpatterns.liskov.good.world;

import com.clarsen.designpatterns.liskov.good.model.Vehicle;

public class RegularRoad implements Road<Vehicle> {
    @Override
    public void traverse(Vehicle v) {
        // Because it was grassy and wanted wear;
    }
}
