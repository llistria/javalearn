package com.mjc813;

public class Phone {
    String owner;
    
    Phone(String owner){
        this.owner = owner;
    }
    
    void turnOn(){
        System.out.println("전원을 켭니다");
    }
    void turnOff(){
        System.out.println("전원을 끕니다");

    }
}
