package com.example.demo.demo;

import com.example.demo.demo.components.Drummer;
import com.example.demo.demo.components.Guitarist;
import com.example.demo.demo.components.Trombonist;
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
