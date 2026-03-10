package com.mjc813;
import java.util.*;
public class HSE {
    public static void main(){
        Set<String> set = new HashSet<String>();

        set.add("Java");
        set.add("Jdbc");
        set.add("Jsp");
        set.add("Java");
        set.add("Spring");

        int size = set.size();
            System.out.println("총 객체 수: "+ size);


    }
}
