package com.jocata.externalServices.controller;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        return "Hello  "+name;
    }


}
