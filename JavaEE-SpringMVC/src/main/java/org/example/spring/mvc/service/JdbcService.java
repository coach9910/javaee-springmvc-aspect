package org.example.spring.mvc.service;
import org.example.spring.mvc.bean.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("org.example.spring.mvc.*")
@EnableAspectJAutoProxy
public class JdbcService {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JdbcService.class);
       Student Student = context.getBean("student",Student.class);
       Student.getSno();

    }
}
