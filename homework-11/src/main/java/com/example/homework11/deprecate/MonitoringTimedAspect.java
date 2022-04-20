package com.example.homework11.deprecate;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log
public class MonitoringTimedAspect {

    @Around("@annotation(com.example.homework11.deprecate.MonitoringTimed)")
    public Object timer(ProceedingJoinPoint point) throws Throwable {
        long startAt = System.nanoTime();
        try {
            return point.proceed();
        } finally {
            long executedTime = (System.nanoTime() - startAt) / 1000;
            log.warning("execution took " + executedTime);
        }
    }
}
