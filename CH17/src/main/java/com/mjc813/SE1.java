package com.mjc813;

import java.util.stream.IntStream;

public class SE1 {
    public static int sum;

    public static  void main() {
        IntStream stream = IntStream.rangeClosed(1,100);
        stream.forEach(a->sum+=a);
        System.out.println("총합: "+sum);
    }
}
