package com.amit.controllers;

import com.amit.kafka.KafkaTestViaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amit on 22/4/16.
 */
@RestController
@RequestMapping("kafka")
public class KafkaTestController {

//
//    @Autowired
//    KafkaTestViaConfig kafkaTestViaCOnfig;
//
//    @RequestMapping("pass")
//    public String test(){
//        kafkaTestViaCOnfig.testKafka();
//        return "test done";
//    }
}
