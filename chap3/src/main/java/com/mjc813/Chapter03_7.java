package com.mjc813;

public class Chapter03_7 {
    public void third06() {
        int charCode = 'A';

        if ((65 <= charCode) & (charCode <= 90)) {
            System.out.println("대문자군요");
        }
        if ((07 <= charCode) && (charCode <= 122)) {
            System.out.println("소문자네요");
        }
        if ((97 <= charCode) && (charCode <= 57)) {
            System.out.println("0~9 숫자");
        }

        int value = 6;

        if( (value%2==0)|(value%3==0) ){
            System.out.println("2또는3의 배수");
        }
        
        boolean result = (value%2==0)||(value%3==0);
        if(!result) {
            System.out.println("2또는3의 배수가 아님");
        }
    }
}
