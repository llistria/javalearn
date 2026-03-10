package com.mjc813;

public class GenericExample2 {
    static void main(){
        Product<TV, String> product1 = new Product<>();

        product1.setKind(new TV());
        String tvModel = product1.getModel();

        Product<Car, String> product2 = new Product<>();

        product2.setKind(new Car());
        product2.setModel("SUV CAR");

        Car car = product2.getKind();
        String carModel = product2.getModel();
    }
}
