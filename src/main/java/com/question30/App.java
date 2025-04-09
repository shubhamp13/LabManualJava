package com.question30;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
        Student student= context.getBean(Student.class);
        System.out.println(student);
        ApplicationContext context1=new AnnotationConfigApplicationContext(AppConfig.class);
        Student student1= context1.getBean(Student.class);
        System.out.println(student1);
    }
}
