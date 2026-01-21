package com.mjc813;

public class ch05_ex2 {
    public void FI_EX2(){
        int[][] intDemention2 = {
                {1, 0, 1, 0, 0, 1}
                , {1, 0, 1, 1, 0, 1}
                , {0, 1, 0, 1, 0, 0}
                , {1, 0, 0, 1, 0, 1}
                , {1, 0, 1, 0, 0, 1}
        };

        int one = 0;
        int zero = 0;
        for (int i = 0; i < intDemention2.length; i++) {
            for (int k = 0; k < intDemention2[i].length; k++){
                if( intDemention2[i][ k] == 0){
                    zero ++;
                }
                else{
                    one ++;
                }
            }

        }
        System.out.println("0의 개수는: "+zero + "  1의 개수는 : "+one);
    }
}
