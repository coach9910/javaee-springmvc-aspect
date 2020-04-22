package org.example.spring.mvc.controller;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component
@Aspect
public class AopTransactionUtils{

    @Autowired
    private TransactionUtils TransactionUtils;


    @Around("execution(* org.example.spring.mvc.jdbc.StudentHomeworkJdbc.handHomework(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        System.out.println("环绕通知开始....开启事务");
        TransactionStatus begin = TransactionUtils.begin();
        //调用方法，如果调用方法抛出异常，不会执行后面的代码
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知结束.....提交事务");
        TransactionUtils.commit(begin);

    }

    @AfterThrowing("execution(* org.example.spring.mvc.jdbc.StudentHomeworkJdbc.handHomework(..))")
    public void afterthrowing(){
        System.out.println("异常通知....回滚事务");
        //获取当前事务 直接回滚
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
}
