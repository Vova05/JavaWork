package com.example.demo;

import com.example.demo.components.Drummer;
import com.example.demo.components.Guitarist;
import com.example.demo.components.Trombonist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoConfig.class);
        Drummer j = applicationContext.getBean(Drummer.class);
        System.out.println(j.doCoding());
        Guitarist m = applicationContext.getBean(Guitarist.class);
        System.out.println(m.doCoding());
        Trombonist s = applicationContext.getBean(Trombonist.class);
        System.out.println(s.doCoding());
        //SpringApplication.run(DemoApplication.class, args);
    }

}
