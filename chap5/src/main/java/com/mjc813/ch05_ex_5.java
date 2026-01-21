package com.mjc813;

public class ch05_ex_5 {
    public void FI_EX_5() {
        double[] dArray = new double[25];
        for (int i = 0; i < dArray.length; i++) {
            dArray[i] = (Math.random() * 100);
            System.out.println(dArray[i]);
        }

    }

}
