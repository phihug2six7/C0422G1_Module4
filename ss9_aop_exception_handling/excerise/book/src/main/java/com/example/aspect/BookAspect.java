package com.example.aspect;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {
    private static int count=1;
    @AfterReturning(pointcut = "execution(* com.example.controller.BookController.*(..))")
    public static void countPoint(JoinPoint joinPoint){
        String nameP=joinPoint.getSignature().getName();
        int cow=count++;
        System.err.println("Phương thức "+ nameP +"chạy"+ cow );
    }
}
