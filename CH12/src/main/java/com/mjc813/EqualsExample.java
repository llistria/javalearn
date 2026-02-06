package com.mjc813;

public class EqualsExample {
    public void ee(){
        Member2 obj1 = new Member2("blue");
        Member2 obj2 = new Member2("blue");
        Member2 obj3 = new Member2("red");

        if (obj1.equals(obj2)){
            System.out.println("obj1은 obj2와 동등합니다");
        }else {
            System.out.println("obj1은 obj2와 동등하지 않습니다");

        }
        if (obj1.equals(obj3)){
            System.out.println("obj1은 obj2와 동등합니다");
        }else {
            System.out.println("obj1은 obj2와 동등하지 않습니다");

        }
    }
}
