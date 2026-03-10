package com.mjc813;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.List;
public class SE {
    static void main(){
        List<Product> list = new ArrayList<>();
        for (int i=1; i<=20; i++){
            Product product = new Product(i,"상품"+i,"멋진회사",(int)(10000*Math.random()));
            list.add(product);
        }

        Stream<Product> stream = list.stream();
        stream.forEach(System.out::println);
    }
}
