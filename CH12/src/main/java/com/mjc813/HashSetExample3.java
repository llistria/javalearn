package com.mjc813;
import java.util.*;
public class HashSetExample3 {
    public void hse3() {
        Set<String> set = new HashSet<String>();

        set.add("java");
        set.add("jdbc");
        set.add("jsp");
        set.add("Spring");

        Iterator<String> integer = set.iterator();
        while (integer.hasNext()){
            String element = integer.next();
            System.out.println(element);
            if (element.equals("JSP")){
                integer.remove();
            }
        }
        System.out.println();

        set.remove("jdbc");

        for (String element : set){
            System.out.println(element);
        }
    }
}