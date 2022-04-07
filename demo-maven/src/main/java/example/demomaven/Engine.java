package example.demomaven;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
