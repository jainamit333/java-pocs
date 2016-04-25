package com.amit.controllers;


import com.amit.kafka.KafkaHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amit on 22/4/16.
 */
@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Autowired
    KafkaHandler kafkaHandler;


    @RequestMapping("send")
    public String senfDataToKafka(){

        kafkaHandler.sendDataToKafka("Senf Dummy Data to kafka Docker");
        return "done";
    }


}
