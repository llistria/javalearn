package com.mjc813;
import java.util.*;
public class HashSetExample2 {
    public void hse2(){
        Set<Member> set = new HashSet<Member>();

        set.add(new Member("김준식", 23));
        set.add(new Member("유은후", 24));

        System.out.println("총 객체 수" + set.size());
    }
}
