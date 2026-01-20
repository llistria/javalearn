package com.mjc813;

public class ch05_05_6 {
    static void FI05_6(){
      String ssn = "040913-12344567";

      String firstNum = ssn.substring(0,6);
      System.out.println(firstNum);
      String secondNum = ssn.substring(7);
      System.out.println(secondNum);

    }
}
