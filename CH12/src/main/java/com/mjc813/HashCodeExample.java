package com.mjc813;

public class HashCodeExample {
    public void hce(){
        Student s1 = new Student(1,"전서현");
        Student s2 = new Student(1,"전서현");
        
        if (s1.hashCode() == s2.hashCode()){
            if (s1.equals(s2)){
                System.out.println("동등 객체입니다");
            }else {
                System.out.println("데이터가 다름으로 동등 갹체가 아닙니다");
            }
            }else {
                System.out.println("해시코드가 다름으로 동등 갹체가 아닙니다");
            }

        }
    }
