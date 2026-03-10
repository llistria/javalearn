package com.mjc813;

public class GenericExample4 {
    static void main(){
        Box<String> box1 = new Box<>();
        box1.content = "100";

        Box<String>  box2 = new Box<>();
        box2.content = "100";

        boolean result1 = box1.compare(box2);
        System.out.println("result1: " + result1);
    }
}
