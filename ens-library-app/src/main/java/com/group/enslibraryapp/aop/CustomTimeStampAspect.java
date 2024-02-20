package com.group.enslibraryapp.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
@Slf4j
public class CustomTimeStampAspect {

    @Before("@annotation(com.group.enslibraryapp.annotation.CustomTimeStamp)")
    public void beforeTimeStamp(JoinPoint joinPoint) {
       log.info("현재 시간 : {} ",LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss")));
       log.info("Controller() -> {}",joinPoint.getSignature().getName());
    }
}
