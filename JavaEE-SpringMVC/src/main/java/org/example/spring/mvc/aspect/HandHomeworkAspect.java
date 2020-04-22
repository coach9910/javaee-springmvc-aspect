package org.example.spring.mvc.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HandHomeworkAspect {
    @Before("execution(* org.example.spring.mvc.jdbc.StudentHomeworkJdbc.handHomework(..))")
    public  void beforeService(){System.out.println("Before handing homework!");}

    @After("execution(* org.example.spring.mvc.jdbc.StudentHomeworkJdbc.handHomework(..))")
    public  void afterService(){System.out.println("After handing homework!");}

    @Around("execution(* org.example.spring.mvc.jdbc.StudentHomeworkJdbc.handHomework(..))")
    public Object aroundService(ProceedingJoinPoint jp){
        Object object = null;
        try{
            System.out.println("Before around handing homework!");
            object = jp.proceed();
            System.out.println("After around handing homework!");
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return object;
    }
}
