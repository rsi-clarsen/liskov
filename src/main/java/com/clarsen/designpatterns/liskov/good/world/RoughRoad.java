package com.clarsen.designpatterns.liskov.good.world;

import com.clarsen.designpatterns.liskov.good.model.MotorizedVehicle;

public class RoughRoad implements Road<MotorizedVehicle>{
    public void traverse(MotorizedVehicle v) {
        // Because it was grassy and wanted wear;
    }
}
