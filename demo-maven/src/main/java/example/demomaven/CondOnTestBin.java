package example.demomaven;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@ConditionalOnBean({testProfile.class})
@Component
public class CondOnTestBin {
    @PostConstruct
    void PostConstruct() {
        System.out.println("2 bin");
    }
}
