package example.demomaven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@SpringBootApplication(proxyBeanMethods = true)
public class DemoMavenApplication {

    public static void main(String[] args) {
        var program = SpringApplication.run(DemoMavenApplication.class, args);
        program.close();
    }

}

@Service
class My {
    @Autowired
    CarService carService;
    @Autowired
    Publisher publisher;

    @PostConstruct
    void post() {
        System.out.println("**");
        Engine e = new Engine();
        e.setData(3);
        System.out.println("* = " + carService.m(e));
        e.setData(4);
        System.out.println("* = " + carService.m(e));
        System.out.println("жжжж");
    }
}
