package com.mjc813;

public class CarExample {
    public static void carex(){
        Car myCar = new Car();

        myCar.setSpeed(-50);
        System.out.println("현재속도"+myCar.getSpeed());

        myCar.setSpeed(60);
        System.out.println("현재속도"+myCar.getSpeed());

        if(!myCar.isStop()){
            myCar.setStop(true);
        }
        System.out.println("현재속도"+myCar.getSpeed());
    }
}
