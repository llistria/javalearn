package com.mjc813;
import java.lang.reflect.Member;
import java.util.*;
public class HSE2 {
    static void main(){
        Set<M> set = new HashSet<M>();

        set.add(new M("홍길동",30));
        set.add(new M("홍길동",30));

        System.out.println("총 객체 수: "+ set.size());
    }
}
