package com.mjc813;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarExample {
    public static void asd(String[] args){
        Car myCar = new Car();

        myCar.tire = new Tire();
        myCar.run();

        myCar.tire = new HankookTire();
        myCar.run();

        myCar.tire = new KumhoTire();
        myCar.run();

    }
}
