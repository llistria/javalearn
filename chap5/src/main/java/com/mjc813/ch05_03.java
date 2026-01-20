package com.mjc813;

public class ch05_03 {
    public void FI03(){
        int[] arr1;
        int[] arr2;
        int[] arr3;

        arr1 = new int[] {1,2,3};
        arr2 = new int[] {1,2,3};
        arr3 = arr2;

        System.out.println(arr1==arr2);
        System.out.println(arr2==arr3);
    }

}
