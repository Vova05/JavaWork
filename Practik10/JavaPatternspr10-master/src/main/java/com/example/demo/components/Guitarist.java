package com.example.demo.components;

import com.example.demo.Programmer;
import org.springframework.stereotype.Component;

@Component
public class Middle implements Programmer {
    @Override
    public String doCoding() {
        return "Guitarist play..." +
                "\nEeeeeeeee!!!!!!!";
    }
}
