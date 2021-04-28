package com.example.practik12.config;
import lombok.Getter;
import lombok.Setter;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter @Setter @Component
public class Config {
    @Value("src/main/java/com/example/demo/${source}")
    private String sourcePath;
    @Value("src/main/java/com/example/demo/${out}")
    private String newPath;

    @PostConstruct
    private void init(){
        System.out.println("Start converting...");
    }

    @PreDestroy
    private void destroy(){
        System.out.println("Destroying...");
    }
}
