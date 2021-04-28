package com.example.demo.demo.components;

import com.example.demo.demo.Musician;
import org.springframework.stereotype.Component;

@Component
public class Drummer implements Musician {
    @Override
    public String doCoding() {
        return "Drummer play...";
    }
}
