package com.mjc813;

public class LE {
    static void main() {
        action((x,y) -> {
            int result = x + y;
            System.out.println("resilt: " + result);
        });

        action((x,y) ->{
           int result =  x - y;
            System.out.println("resilt: " + result);
        });
    }

    public static void action(Calculable calculable){
        int x = 10;
        int y = 4;

        calculable.calculate(x,y);
    }
}
