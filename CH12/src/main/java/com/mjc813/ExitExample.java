package com.mjc813;

public class ExitExample {
    public void EE(){
        for (int i = 0; i < 10; i++){
            System.out.println(i);
            if (i == 5){
                System.out.println("프로세스 강제 종료");
                System.exit(0);
            }
        }
    }
}
