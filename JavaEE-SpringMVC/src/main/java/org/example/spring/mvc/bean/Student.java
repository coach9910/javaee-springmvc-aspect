package org.example.spring.mvc.bean;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration


@Component
public class Student {

    private int sno;

    private String sname;


    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
