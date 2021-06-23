package com.fasecovidsp.whatsappInterface.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
    @GetMapping
    public String helloWorld(String nome){
        if(nome==null){
            return "Hello World";
        }
        return "Hello, "+ nome;
    }
}
