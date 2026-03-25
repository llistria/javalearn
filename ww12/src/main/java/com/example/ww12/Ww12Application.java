package com.example.ww12;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ww12.gamecrud")
public class Ww12Application {

    public static void main(String[] args) {
        SpringApplication.run(Ww12Application.class, args);
    }
}
