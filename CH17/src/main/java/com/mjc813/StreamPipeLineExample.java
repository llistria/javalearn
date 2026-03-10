package com.mjc813;
import java.util.Arrays;
import java.util.List;
public class StreamPipeLineExample {
    static void main(){
        List<Student> list = Arrays.asList(
        new Student("전서현", 12),
        new Student("김동진", 25),
        new Student("박서진", 42)
        );
        double avg = list.stream()
                .mapToInt(Student::getScore)
                .average()
                .getAsDouble();

        System.out.println("평군점수: "+ avg);
    }
}

