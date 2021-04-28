package com.example.practik111;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestRequest {
    @RequestMapping("/")
    public String RestRequest(){
        return "OK";
    }
}
