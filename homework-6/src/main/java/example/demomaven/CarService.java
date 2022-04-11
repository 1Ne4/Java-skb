package example.demomaven;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

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
