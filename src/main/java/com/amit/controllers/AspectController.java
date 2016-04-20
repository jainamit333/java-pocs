package com.amit.controllers;

import com.amit.aspect.CustomerBoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amit on 20/4/16.
 */
@RestController
@RequestMapping("aspect")
public class AspectController {

    @Autowired
    public CustomerBoImpl customerBo;

    @RequestMapping("before")
    public String callBeforeAspect(){
        customerBo.addCustomer();
        return "Called";

    }
}
