package com.mjc813;

import java.lang.reflect.Member;

public class M {
    public String name;
    public int age;

    public M(String name, int age){
        this.name = name;
        this.age = age;

    }

    @Override
    public int hashCode(){
        return name.hashCode()+age;
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof M target){
            return target.name.equals(name)&&(target.age==age);
        }else {
            return false;
        }
    }
}
