package com.mjc813;

public class sec09_2 {
    public void howToUseVariable(){
    int result1 = 10 + 2 + 8;
        System.out.println("result1: "+result1);

    String result2 = 10 + 2 + "8";
        System.out.println("result1: "+result2);

    String result3 = 10 + "2" + "8";
        System.out.println("result1: "+result3);

    String result4 = "10" + 2 + 8;
        System.out.println("result1: "+result4);

    String result5 = "10" + (2 + 8);
        System.out.println("result1: "+result5);
    }
}
