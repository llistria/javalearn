package com.mjc813;

public class ch05_05_3 {
    static void FI05_3(){
        String ssn ="124453221";
        char sex = ssn.charAt(6);
        switch (sex) {
            case '1':
            case '3':
             System.out.println("남자입니다");
             break;
            case '2':
            case '4':
                System.out.println("여자입니다");
                break;
        }
    }
}
