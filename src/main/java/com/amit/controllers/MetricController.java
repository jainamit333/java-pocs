package com.amit.controllers;

import com.amit.metric.AnnotationConsumer;
import com.amit.metric.DummyRequestAdapter;
import com.amit.metric.DummyResponseAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amit on 19/4/16.
 */
@RestController
@RequestMapping("metric")
public class MetricController {

//
//    @Autowired
//    AnnotationConsumer annotationConsumer;
//
//    @Autowired
//    DummyRequestAdapter dummyRequestAdapter;
//
//    @Autowired
//    DummyResponseAdapter dummyResponseAdapter;
//
//
//    @RequestMapping("meter")
//    public String invokeMeter(){
//        return annotationConsumer.foo();
//    }
//
//
//    @RequestMapping("meter/request")
//    public String invokeMeterWithName1(){
//        return annotationConsumer.fooWithName1();
//    }
//
//    @RequestMapping("meter/response")
//    public String invokeMeterWithName2(){
//        return annotationConsumer.fooWithName2();
//    }
//
//
//    @RequestMapping("meter/innermethod")
//    public String invokeInnerMethod(){
//        return annotationConsumer.callFoo();
//
//    }
//
//    @RequestMapping("gauge")
//    public String addValueToQueue(){
//        annotationConsumer.addValueToQueue();
//        return "done";
//    }
//
//    @RequestMapping("timer")
//    public Integer getTimer(){
//        return annotationConsumer.getTimed();
//
//    }
//
//    @RequestMapping("meter/innerprivatemethod")
//    public String invokeInnerPrivateMethod(){
//        return annotationConsumer.callPrivateBoo();
//    }
//
//
//    @RequestMapping("meter/counter")
//    public String invokeCounter(){
//        return annotationConsumer.counter();
//    }
//
//    @RequestMapping("frame/request")
//    public String frameWorkTestRequest(){
//        return dummyRequestAdapter.map("abc");
//    }
//
//
//    @RequestMapping("frame/response")
//    public String frameworkResponse(){
//        return dummyResponseAdapter.map("12");
//    }

}
