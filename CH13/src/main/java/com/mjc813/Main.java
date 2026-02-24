package com.mjc813;

public class Main {
    public static void main(String[] args) {
        Packaging pkg = new Packaging();

        // 1. String 3개 추가 (Add)
        pkg.add(new Human("김철수", 25));
        pkg.add(new Human("이영희", 30));
        pkg.add(new Human("박민수", 22));
        System.out.println("Human 객체 3개를 추가했습니다.");
       


        Human h1 = (Human) pkg.remove();
        System.out.println("삭제 1: " + h1); // 박민수, 22

        Human h2 = (Human) pkg.remove();
        System.out.println("삭제 2: " + h2); // 이영희, 30

    }
}