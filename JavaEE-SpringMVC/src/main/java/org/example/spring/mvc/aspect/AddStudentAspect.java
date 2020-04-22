package org.example.spring.mvc.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AddStudentAspect {
    @Before("execution(* org.example.spring.mvc.jdbc.StudentJdbc.addStudent(..))")
    public  void beforeService(){System.out.println("Before adding student!");}

    @After("execution(* org.example.spring.mvc.jdbc.StudentJdbc.addStudent(..))")
    public  void afterService(){System.out.println("After adding student!");}

    @Around("execution(* org.example.spring.mvc.jdbc.StudentJdbc.addStudent(..))")
    public Object aroundService(ProceedingJoinPoint jp){
        Object object = null;
        try{
            System.out.println("Before around Student!");
            object = jp.proceed();
            System.out.println("After around Student!");
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return object;
    }
}
