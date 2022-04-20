package com.example.homework11;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BusinessService {
    private Counter counterOfUsingAPI;
    private Counter counter;
    private final MeterRegistry meterRegistry;

    public BusinessService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void init() {
        counterOfUsingAPI = Counter.builder("order_created")
                .description("number of orders created")
                .register(meterRegistry);
        counter = Counter.builder("counter_created").register(meterRegistry);
    }

    @Timed(value = "say.time", description = "Time to say")
    @Counted(value = "say.count", description = "Count of using say API")
    public void say() {
        System.out.println("amogus");//*Business Logic*
    }

    public void businessLogic() {
        counterOfUsingAPI.increment();
    }

    @Scheduled(fixedRate = 1500)
    public void incrementCounter() {
        counter.increment();
    }
}
