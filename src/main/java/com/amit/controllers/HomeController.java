package com.amit.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amit on 14/4/16.
 */

@RestController
public class HomeController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String root(){
        return "I am Root ";
    }

    @RequestMapping("/test")
    public String test(){
        return "I am working ";
    }

}
