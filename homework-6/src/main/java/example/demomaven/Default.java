package example.demomaven;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("!default")
public class Default {
    @PostConstruct
    void PostConstruct() {
        System.out.println("Using not default Profile");
    }
}
