package com.example.homework9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class Homework9Application {

    private static BusinessService service;

    public Homework9Application(BusinessService inputService) {
        service=inputService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Homework9Application.class, args);
        service.doSomeStuff();
    }

}
