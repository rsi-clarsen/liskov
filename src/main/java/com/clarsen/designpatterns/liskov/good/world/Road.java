package com.clarsen.designpatterns.liskov.good.world;

import com.clarsen.designpatterns.liskov.good.model.Vehicle;

public interface Road<T extends Vehicle> {
    public void traverse(T v);
}
