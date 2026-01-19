package com.mjc813;

public class Main {
    static void main() {
        Chapter04_2 v01 = new Chapter04_2();
        v01.fourth02();
        
        int score = 93;
        
        if(score >=90){
            System.out.println("점수가 90보타 큽니다");
            System.out.println("등급은 A 입니다");
        
        }
        if(score < 90){
            System.out.println("점수가 90보다 잡습니다");
            System.out.println("등급은 B 입니다");
        }

    }
}
