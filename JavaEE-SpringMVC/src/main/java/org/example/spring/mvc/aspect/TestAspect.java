package org.example.spring.mvc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
    @Pointcut("execution(* org.example.spring.mvc.bean.*.*(..))")
    public void service() {}

    @Before("service()")
    public  void beforeService(){System.out.println("Before Service!");}

    @After("service()")
    public  void afterService(){System.out.println("Before Service!");}

    @Around("service()")
    public Object aroundService(ProceedingJoinPoint jp){
        Object object = null;
        try{
            System.out.println("Before around Service!");
            object = jp.proceed();
            System.out.println("After around Service!");
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return object;
    }


}
