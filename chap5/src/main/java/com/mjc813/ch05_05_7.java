package com.mjc813;

public class ch05_05_7 {
    static void FI05_7() {
        String subject = "자바 프로그래밍";

        int location = subject.indexOf("프로그래밍");
        System.out.println(location);
        String substring = subject.substring(location);
        System.out.println(substring);

        location = subject.indexOf("자바");
        if(location != -1){
            System.out.println("자바책");
        }else {
            System.out.println("자바책아님");
        }

        boolean result = subject.contains("자바");
        if(result){
            System.out.println("자바 관련 책");
        }else {
            System.out.println("자바관련책아님");
        }
    }
}