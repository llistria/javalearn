package com.mjc813;
import java.util.*;
public class HashSetExample {
    public void hse(){
        Set<String> set = new HashSet<String>();

        set.add("java");
        set.add("jdbc");
        set.add("jsp");
        set.add("Spring");
        set.add("java");

        int size = set.size();
        System.out.println("총 객체 수" + size);
    }
}
