package example.demomaven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
public class DemoMavenApplication {

    public static void main(String[] args) {
        var program=SpringApplication.run(DemoMavenApplication.class, args);
        program.close();
    }

}

interface Interf{
    void method();
}

@Component
class Car1 {
    @Autowired
    private Engine engine;

}

@Component
class Car2 {

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    private Engine engine;

}

@Component
class Car3 implements Interf{

    private Engine engine;

    public Car3(Engine engine) {
        this.engine = engine;
    }

    @PostConstruct
    void PostConstruct(){
        System.out.println("Car3 Создан");
    }

    @PreDestroy
    void PreDestroy(){
        System.out.println("Car3 Уничтожен");
    }

    @Override
    public void method() {

    }
}

@Component
class Engine implements Interf{

    @Override
    public void method() {

    }

    @PostConstruct
    void PostConstruct(){
        System.out.println("Engine Создан");
    }

    @PreDestroy
    void PreDestroy(){
        System.out.println("Engine Уничтожен");
    }
}

@Component
class CarService{
    private Engine engine;
    private Car3 car;

    public CarService(Engine engine, Car3 car) {
        this.engine = engine;
        this.car = car;
    }
}