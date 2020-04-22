package org.example.spring.mvc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AddHomeworkAspect {
    @Before("execution(* org.example.spring.mvc.jdbc.HomeworkJdbc.addHomework(..))")
    public  void beforeService(){System.out.println("Before adding homework!");}

    @After("execution(* org.example.spring.mvc.jdbc.HomeworkJdbc.addHomework(..))")
    public  void afterService(){System.out.println("After adding homework!");}

    @Around("execution(* org.example.spring.mvc.jdbc.HomeworkJdbc.addHomework(..))")
    public Object aroundService(ProceedingJoinPoint jp){
        Object object = null;
        try{
            System.out.println("Before around Homework!");
            object = jp.proceed();
            System.out.println("After around Homework!");
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return object;
    }
}
