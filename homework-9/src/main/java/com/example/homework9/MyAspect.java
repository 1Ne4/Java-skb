package com.example.homework9;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Log
public class MyAspect {
    @Value("${aspect.maxCount}")
    private int maxCount;
    private int counter = 0;

    @Around("within(com.example.homework9.BusinessService)")
    public Object method(ProceedingJoinPoint point) throws Throwable {
        log.info(String.valueOf(maxCount));
        counter++;
        if (counter <= maxCount)
            return point.proceed();
        return null;
    }
}
