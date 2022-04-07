package example.demomaven;

import org.springframework.context.ApplicationEvent;

public class TransactionalEvent extends ApplicationEvent {
    private String message;

    public TransactionalEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
