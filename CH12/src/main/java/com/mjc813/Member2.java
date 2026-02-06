package com.mjc813;

public class Member2 {
    public String id;

    public Member2(String id){
        this.id = id;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member2 target) {
            return id.equals(target.id);
        }
        return false;

    }
}