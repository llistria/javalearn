package com.mjc813;

public class ch05_04_2 {
    public void FI04_2(){
        String hobby = "여행";
        hobby = null;

        String kind1 = "자동차";
        String kind2 = kind1;
        kind1 = null;
        System.out.println("kind2: " + kind2);
    }
}
