package com.mjc813;

public class GE {
    public static <T> Box2<T> boxing(T t){
        Box2<T> box2 = new Box2<>();
        box2.set(t);
        return box2;
    }

    public static void main(){
        Box2<Integer> box1 = boxing(100);
        int intValue = box1.get();
        System.out.println(intValue);

        Box2<String> box2 = boxing("홍길동");
        String strValue = box2.get();
        System.out.println(strValue);
    }
}
