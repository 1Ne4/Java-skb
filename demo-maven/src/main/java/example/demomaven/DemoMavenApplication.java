package example.demomaven;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication(proxyBeanMethods = true)
public class DemoMavenApplication {

    public static void main(String[] args) {
        var program = SpringApplication.run(DemoMavenApplication.class, args);
        program.close();
    }

}

interface Interf {
    void method();
}

@Component
class Car1 {
    @Autowired
    private Engine engine;

}

@Component
class Car2 {

    @Value("${car.name}")
    String name;

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @PreDestroy
    void PreDestroy() {
        System.out.println(name);
    }

    private Engine engine;

}

@Component
class Car3 implements Interf {

    private Engine engine;

    public Car3(Engine engine) {
        this.engine = engine;
    }

    @PostConstruct
    void PostConstruct() {
        System.out.println("Car3 Создан");
    }

    @PreDestroy
    void PreDestroy() {
        System.out.println("Car3 Уничтожен");
    }

    @Override
    public void method() {

    }
}

@Component
class Engine implements Interf {
    @Setter
    @Getter
    private int data = 1;


    @Override
    public void method() {

    }

    @PostConstruct
    void PostConstruct() {
        System.out.println("Engine Создан");
    }

    @PreDestroy
    void PreDestroy() {
        System.out.println("Engine Уничтожен");
    }
}

@Configuration(proxyBeanMethods = true)
class CarService {
    private Interf engine;
    private Interf car;

    @Bean
    long m(Engine engine) {
        System.out.println("m is " + engine.getData());
        return engine.getData();
    }

    @Bean
    long m2() {
        System.out.println("222222");
        Engine e = new Engine();
        e.setData(2);
        System.out.println(m(e));
        return 0;
    }

    public CarService(Interf engine, Interf car3) {
        this.engine = engine;
        this.car = car3;
    }
    @PostConstruct
    void PostConstruct() {
        System.out.println("--CarService Создан");
    }
}

@Service
class My {
    @Autowired
    CarService carService;

    @PostConstruct
    void post() {
        System.out.println("**");
        Engine e = new Engine();
        e.setData(3);
        System.out.println("* = " + carService.m(e));
        e.setData(4);
        System.out.println("* = " + carService.m(e));
        System.out.println("**");
    }
}

