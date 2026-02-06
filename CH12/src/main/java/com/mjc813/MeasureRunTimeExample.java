package com.mjc813;

public class MeasureRunTimeExample {
    public void MRTE(){
        long time1 = System.nanoTime();
        int sim = 0;
        for (int i = 1; i<10000000; i++){
            sim +=1;
        }
        long time2 = System.nanoTime();

        System.out.println("1부터 10000000까지의 합" + sim);
        System.out.println("계산에"+ (time2-time1)+"의 나노초가 소요되었습니다");
    }
}
