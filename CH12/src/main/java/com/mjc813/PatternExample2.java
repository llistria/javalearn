package com.mjc813;

import java.util.regex.Pattern;

public class PatternExample2 {
    public void PE2(){
        String id = "Angel1004";
        String regEXP = "\\w+\\w{8,12}";
        boolean isMatch = Pattern.matches(regEXP, id);
        if (isMatch){
            System.out.println("가능");
        }else {
            System.out.println("불가능");
        }
    }
}
