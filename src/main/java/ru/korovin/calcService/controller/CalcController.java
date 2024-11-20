package ru.korovin.calcService.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calcService")
public class CalcController{

    @GetMapping("/ping")
    public String ping(){
        System.out.println("ping");
        return "ping";
    }
}
