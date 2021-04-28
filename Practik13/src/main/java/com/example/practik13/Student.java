package com.example.practik13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("${student.name}")
    private String name;

    @Value("${student.last_name}")
    private String sure_name;

    @Value("${student.group}")
    private String group;

    @Bean("init")
    public void init() {
        System.out.println(name);
        System.out.println(sure_name);
        System.out.println(group);
    }
}
