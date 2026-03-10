package com.mjc813;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
public class ParallelStreamExample {
    public static void main() {
        List<String> list = new ArrayList<>();
        list.add("전서현");
        list.add("김준식");
        list.add("유은후");
        list.add("홍석영");
        list.add("양동민");


        Stream<String> paralleStream = list.parallelStream();
        paralleStream.forEach(name->{
            System.out.println(name + ":"+Thread.currentThread().getName());
        });
    }
}
