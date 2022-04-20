package com.example.homework11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
public class Homework11Application {
    private static BusinessService bService;

    public Homework11Application(BusinessService bService) {
        Homework11Application.bService = bService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Homework11Application.class, args);
        bService.say();
    }
}
