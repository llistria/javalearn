package com.mjc813;

public class Television implements RemoteControl{
    @Override
    public void poweron() {
        RemoteControl r = new Television();
        r.poweron();
        System.out.println("TV를 켰습니다");
    }

}
