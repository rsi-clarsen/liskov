package com.clarsen.designpatterns.liskov.bad.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {
    protected int powerLevel;

    public void startYourEngine() {
        // boogity boogity boogity lets go racing
    }
}
