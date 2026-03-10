package com.mjc813;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class HME {
    static void main(){
        Map<String, Integer>map = new HashMap<>();

        map.put("김준희",24);
        map.put("전서현",23);
        map.put("김은별",22);
        map.put("김동진",28);
        System.out.println("총 엔트리 수:" + map.size());
        System.out.println();

        String key = "전서현";
        int value = map.get(key);
        System.out.println(key +": " + value);
        System.out.println();

        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()){
            String k = keyIterator.next();
            Integer v = map.get(k);
            System.out.println(k + ":" + v);
        }
        System.out.println();

        Set<Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()){
            Entry<String, Integer> entry = entryIterator.next();
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + ":" + v);

            map.remove("전서현");
            System.out.println("총 엔트리 수: " + map.size());
        }
    }
}
