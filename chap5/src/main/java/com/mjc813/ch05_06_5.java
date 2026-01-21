package com.mjc813;

public class ch05_06_5 {
    public void FI06_5(){
        int[][] scores = new int[][] {
                {80,90,96},
                {76,88}
        };

        System.out.println("1차원 배열 길이(반의 수): " + scores.length);
        System.out.println("1차원 배열 길이(1반의 수): " + scores[0].length);
        System.out.println("1차원 배열 길이(2반의 수): " + scores[1].length);

        System.out.println("scores[0][2]: " + scores[0][2]);
        System.out.println("scores[1][1]: " + scores[1][1]);

        int class1Sum = 0;
        for (int i = 0; i<scores[0].length; i++) {
            class1Sum += scores[0][i];
        }
        double class1Avg = (double) class1Sum / scores[0].length;
        System.out.println("1반의 평균점수: " + class1Avg);

        int class2Sum = 0;
        for (int i = 0; i<scores[1].length; i++) {
            class2Sum += scores[1][i];
        }
        double class2Avg = (double) class2Sum / scores[1].length;
        System.out.println("2반의 평균점수: " + class2Avg);
    }
}
