package example.demomaven;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
