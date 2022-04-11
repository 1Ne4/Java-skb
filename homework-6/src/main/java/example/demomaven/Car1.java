package example.demomaven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class Car1 {
    @Autowired
    private Engine engine;

}
