package com.mjc813;

public class GenericExample3 {
    public static void main(){
        HomeAgency homeAgency= new HomeAgency();
        Home home = homeAgency.rent();
        home.turnOnLight();

        CarAnergy carAnergy = new CarAnergy();
        Car2 car2 = carAnergy.rent();
        car2.run();
    }
}
