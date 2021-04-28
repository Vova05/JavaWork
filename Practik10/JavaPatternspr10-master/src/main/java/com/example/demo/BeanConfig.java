package com.example.demo;

import com.example.demo.components.Junior;
import com.example.demo.components.Middle;
import com.example.demo.components.Senior;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean("Drummer")
    public Drummer drummer() {
        return new Drummer();
    }
    @Bean("Guitarist")
    public Guitarist guitarist() {
        return new Guitarist();
    }
    @Bean("Trombonist")
    public Trombonist trombonist() {
        return new Trombonist();
    }
}
