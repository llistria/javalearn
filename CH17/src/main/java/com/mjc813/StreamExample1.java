package com.mjc813;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class StreamExample1 {
    public static void main(){
        String[] strArray = {"리스터","시안","개꿀빵"};
        Stream<String> stringStream = Arrays.stream(strArray);
        stringStream.forEach(item -> System.out.print(item+","));
        System.out.println();

        int[] intArray = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(intArray);
        intStream.forEach(item->System.out.print(item+","));
        System.out.println();

    }
}
