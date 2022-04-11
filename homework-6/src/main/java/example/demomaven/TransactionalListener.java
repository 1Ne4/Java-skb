package example.demomaven;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalApplicationListener;

import java.util.Objects;


@Log
@Component
public class TransactionalListener implements TransactionalApplicationListener<TransactionalEvent> {

    public void onApplicationEvent(TransactionalEvent event) {
        if (Objects.equals(event.getMessage(), "message"))
            log.info("Handled transactional event - " + event.getMessage());
    }

    @Override
    public void addCallback(SynchronizationCallback callback) {

    }

    @Override
    public void processEvent(TransactionalEvent event) {

    }
}
