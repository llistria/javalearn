package com.mjc813;

import java.util.HashSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class cns {
    public void cnse(String[] args) throws CloneNotSupportedException {
        UseObject uo1 = new UseObject("a1", "a1.use");
        UseObject uo2 = new UseObject("a1", "a1.use");
        if ( uo1.equals(uo2) ) {
            System.out.println("같아요.");
        } else {
            System.out.println("달라요.");
        }

        UseObject uo3 = (UseObject) uo1.clone();    // uo1 을 복사해서 uo3 에 대입
        if ( uo1.equals(uo3) ) {
            System.out.println("같아요.");
        } else {
            System.out.println("달라요.");
        }
        uo3.setName("a1.used");
        System.out.println(uo1);
        System.out.println(uo2);
        System.out.println(uo3);

        HashSet<UseObject> hashUseObject = new HashSet<>();
    }
}