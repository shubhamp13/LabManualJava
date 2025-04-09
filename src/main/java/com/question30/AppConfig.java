package com.question30;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {
        return new Address("MG Road", "Pune", "Maharashtra", "411001");
    }

    @Bean
    public Student student() {
        Student student = new Student();
        student.setName("Shubham");
        student.setAge(22);
        student.setAddress(address());
        return student;
    }
}
