package example.demomaven;

import org.springframework.context.ApplicationEvent;

public class EventForAsync extends ApplicationEvent {
    private String message;

    public EventForAsync(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
