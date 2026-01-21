package com.mjc813;

import java.util.Arrays;

public class ch05_ex_6 {
    public void FI_EX_6() {

        double[] dArray = new double[25];
        for (int i = 0; i < dArray.length; i++) {
            dArray[i] = (Math.random() * 100);
            System.out.println(dArray[i]);
        }

        int[] iArray = new int[25];
        for (int i2 = 0; i2 < iArray.length; i2++) {
            iArray[i2] = (int)dArray[i2];
            System.out.println(iArray[i2]);
        }
        String[] sArray = new String[25];
        for (int i3 = 0; i3 < sArray.length; i3++) {
            sArray[i3] = dArray[i3] + " => " + iArray[i3];
            System.out.println("str["+ i3 + "] = " + sArray[i3]);
        }

    }

}
