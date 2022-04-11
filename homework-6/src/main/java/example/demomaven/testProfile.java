package example.demomaven;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("test")
class testProfile {
    @PostConstruct
    void PostConstruct() {
        System.out.println("Using Test Profile");
    }
}
