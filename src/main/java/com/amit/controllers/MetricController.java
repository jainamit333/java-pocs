package com.amit.controllers;

import com.amit.metric.AnnotationConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amit on 19/4/16.
 */
@RestController
@RequestMapping("metric")
public class MetricController {


    @Autowired
    AnnotationConsumer annotationConsumer;


    @RequestMapping("meter")
    public String invokeMeter(){
        return annotationConsumer.foo();
    }


    @RequestMapping("meter/request")
    public String invokeMeterWithName1(){
        return annotationConsumer.fooWithName1();
    }

    @RequestMapping("meter/response")
    public String invokeMeterWithName2(){
        return annotationConsumer.fooWithName2();
    }
}
