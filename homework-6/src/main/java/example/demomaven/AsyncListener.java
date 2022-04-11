package example.demomaven;

import lombok.extern.java.Log;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Log
@Component
public class AsyncListener implements ApplicationListener<EventForAsync> {
    @Async
    public void onApplicationEvent(EventForAsync event) {
        log.info("Async Received 1 event - " + event.getMessage());
    }
}
