package com.mjc813;

public class ch05_ex {
    public void FI_EX(){
        boolean[] boolArray = new boolean[10];

        for (int i = 0; i < boolArray.length; i++ ){
           if( i % 2 == 0){
               boolArray[i] = true;
           }
        }
    }
}
