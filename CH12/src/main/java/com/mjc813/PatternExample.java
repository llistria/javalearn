package com.mjc813;

import java.util.regex.Pattern;

public class PatternExample {
    public void PE(){
        String regEXP = "(02|010)-\\d{3,4}-\\d{4}";
        String data = "010-123-4567";
        boolean result = Pattern.matches(regEXP, data);
        if (result){
            System.out.println("정규식과 일치합니다");
        }else {
            System.out.println("정규식과 일치하지않습니다");
        }

        regEXP = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
        data = "pizzasksk@naver.com";
        result = Pattern.matches(regEXP, data);
        if (result){
            System.out.println("정규식과 일치합니다");
        }else {
            System.out.println("정규식과 일치하지않습니다");
        }
    }
}
