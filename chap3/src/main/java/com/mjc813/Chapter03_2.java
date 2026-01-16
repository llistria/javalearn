package com.mjc813;

public class Chapter03_2 {
    public void third02(){
        int x = 10;
        int y = 10;
        int z;

        x++;
        ++x;
        System.out.println("x: "+x);

        System.out.println("----------");
        y--;
        --y;
        System.out.println("y: "+y);
        System.out.println("----------");

        z = x++;
        System.out.println("z: "+z);
        System.out.println("x: "+x);

        System.out.println("----------");
        z = ++x;
        System.out.println("z: "+z);
        System.out.println("x: "+x);

        System.out.println("----------");
        z = ++x + y++;
        System.out.println("z: "+z);
        System.out.println("x: "+x);
        System.out.println("y: "+y);
    }
}
