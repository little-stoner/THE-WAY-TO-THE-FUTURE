package com.stone;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class CusAspect {

    @Before("execution(* list(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println(" >>> before join point execute ");
        System.out.println(joinPoint.getSignature().getName());
    }

}
