package example.demomaven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

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
