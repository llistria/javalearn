package com.mjc813;

public class ch05_06_4 {
    public void FI06_4(){
        int[]scores={89, 90, 96};

        int sum = 0;
        for (int i = 0; i<scores.length;i++){
            sum += scores[i];
        }
        System.out.println("총합 ; " + sum);

        double avg = (double) sum / scores.length;

        System.out.println("평군 : "+ avg);

    }
}
