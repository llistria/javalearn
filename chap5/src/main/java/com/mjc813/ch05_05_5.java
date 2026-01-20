package com.mjc813;

public class ch05_05_5 {
    static void FI05_5(){
        String oldStr = "자바 문자열은 불변입니다 자바 문자열은 String입니다";
        String newStr = oldStr.replace("자바","JAVA");

        System.out.println(oldStr);
        System.out.println(newStr);
    }
}
