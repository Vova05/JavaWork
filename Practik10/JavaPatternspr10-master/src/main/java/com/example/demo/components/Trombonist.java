package com.example.demo.components;

import com.example.demo.Programmer;
import org.springframework.stereotype.Component;

@Component
public class Senior implements Programmer {
    @Override
    public String doCoding() {
        return "Trombonist play...";
    }
}
