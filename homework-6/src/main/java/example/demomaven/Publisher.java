package example.demomaven;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.logging.Level;

@Log
@Component
public class Publisher {
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent(final String message) {
        log.log(Level.INFO,"Publishing Classic event.");
        Event event = new Event(this, message);
        applicationEventPublisher.publishEvent(event);
        log.log(Level.INFO,"Publishing Async event.");
        applicationEventPublisher.publishEvent(new EventForAsync(this,message));
        log.log(Level.INFO,"Publishing Transactional event.");
        applicationEventPublisher.publishEvent(new TransactionalEvent(this,message));
        applicationEventPublisher.publishEvent(new TransactionalEvent(this,"message"));
    }

    @PostConstruct
    void post() {
        publishEvent("PublisherOfClassicEventCreated");
    }
}
