package com.tss.ioc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hii!! Hello!!";
    }

    @GetMapping("/bye")
    public String bye()
    {
        return "Bye!!!";
    }

    @GetMapping("/hi")
    public String hi(){return "HII";}
}
