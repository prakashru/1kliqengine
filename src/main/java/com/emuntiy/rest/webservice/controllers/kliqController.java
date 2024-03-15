package com.emuntiy.rest.webservice.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class kliqController {

//    @RequestMapping(method = RequestMethod.GET , path = "/hello-word")
//    //@GetMapping(path="/health")
//    public String healthcheck(){
//        return "success";
//    }

    //@GetMapping(path = "/hello-world")
    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping("/hellobean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

}
