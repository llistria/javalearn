package com.mjc813;

public class InstanceofExample {
    public static void personInfo(Person person) {
        System.out.println("name" + person.name);
        person.walk();

        if (person instanceof Student student) {
            System.out.println("studentNo" + student.studentNo);
            student.study();
        }
    }

    public static void ps (){
        Person p1 = new Person("홍길동");
        personInfo(p1);

        Person p2 = new Student("고길동",10);
        personInfo(p2);
    }
}