# Liskov Substitution Principle

The ***liskov substitution principle*** states that any function or reference from any base class must also be able to use derived classes while being unaware of the derived class.

> Liskov's notion of a behavioural subtype defines a notion of substitutability for objects; that is, if ***S*** is a subtype of ***T***, then objects of type ***T*** in a program may be replaced with objects of type ***S*** without altering any of the desirable properties of that program  
[Wikipedia.org](https://en.wikipedia.org/wiki/Liskov_substitution_principle)

## The Bad

Liskov helps to keep the mind of a programmer thinking about real world behaviors of the objects being modeled.  We can think about a `Car` as a `Vehicle` and model it as such.

[Vehicle](src/main/java/com/clarsen/designpatterns/liskov/bad/model/Vehicle.java)
```
public class Vehicle {
    protected int powerLevel;

    public void startYourEngine() {
        // boogity boogity boogity lets go racing
    }
}
```

[Car](src/main/java/com/clarsen/designpatterns/liskov/bad/model/Car.java)
```
public class Car extends Vehicle {
    @Override
    public void startYourEngine() {
        super.startYourEngine();
    }
}
```

We also create an object that allows a `Vehicle` to traverse down a road.
```
public class Road {
    public void traverse(Vehicle v) {
        // Because it was grassy and wanted wear;
    }
}
```

We can send our `Car` down the `Road`:
```
Road rd = new Road();
Vehicle vh = new Car();

rd.traverse(vh);
```

Say now we want to send a `Bicycle` down the same road.  We could create our model and let it ride.
```
public class Bicycle extends Vehicle {
}
```

We can still send the bike down the road, but it doesn't seem correct for the `Bicycle` to have access to the `startYourEngine` member function.
```
Road rd = new Road();
Bicycle b = new Bicycle();

b.startYourEngine();

rd.traverse(b);
```

## The Good

`Vehicle` defines the power level and the ability to start the engine.  This makes sense for `Car` because they have engines and varying degrees of power levels.  Although; what about the bicycle?  In the real world, if a bicycle had an engine then it would be consider a motorcycle--something completely different.  Since the `Bicycle` is a `Vehicle` but doesn't have an engine, then it shouldn't have access to the `startYourEngine` method.

We can introduce a better model with a `MotorizedVehicle` class and moving the `startYourEngine` member function into it.

[Vehicle](src/main/java/com/clarsen/designpatterns/liskov/good/model/Vehicle.java)
```
public class Vehicle {
    protected int powerLevel;
}
```

[MotorizedVehicle](src/main/java/com/clarsen/designpatterns/liskov/good/model/MotorizedVehicle.java)
```
public class MotorizedVehicle extends Vehicle {
    public void startYourEngine() {
        // boogity boogity boogity lets go racing
    }
}
```

Now in our world lets introduce a rough road that we wouldn't want to send a non-motorized vehicle down.  
[Road Interface](src/main/java/com/clarsen/designpatterns/liskov/good/world/Road.java)
```
public interface Road<T extends Vehicle> {
    public void traverse(T v);
}
```

[RegularRoad](src/main/java/com/clarsen/designpatterns/liskov/good/world/RegularRoad.java)
```
public class RegularRoad implements Road<Vehicle> {
    @Override
    public void traverse(Vehicle v) {
        // Because it was grassy and wanted wear;
    }
}
```

[RoughRoad](src/main/java/com/clarsen/designpatterns/liskov/good/world/RoughRoad.java)
```
public class RoughRoad implements Road<MotorizedVehicle>{
    public void traverse(MotorizedVehicle v) {
        // Because it was grassy and wanted wear;
    }
}
```

The `RegularRoad` will still allow both the `Bicycle` and `Car` to traverse it.  
```
RegularRoad rd = new RegularRoad();
Car car = new Car();
Bicycle b = new Bicycle();

car.startYourEngine();
// b.startYourEngine(); bicycle no longer has access to start an engine

rd.traverse(car);
rd.traverse(b);
```

However; since the `Bicycle` no longer has an engine, it is not allowed to traverse the `RoughRoad`.
```
RoughRoad rd = new RoughRoad();
Bicycle b = new Bicycle();
Car c = new Car();

// rd.traverse(b); cant send a non-motorized vehicle down the rough road
rd.traverse(c);
```