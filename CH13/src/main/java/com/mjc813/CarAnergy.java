package com.mjc813;

public class CarAnergy implements Rentable<Car2>{
    @Override
    public Car2 rent(){
        return new Car2();
    }
}
