package com.amit.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import scala.util.parsing.combinator.testing.Str;

/**
 * Created by amit on 25/4/16.
 */
@Component
public class KafkaHandler {


    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    public void sendDataToKafka(String s){

    kafkaTemplate.convertAndSend("test","key1",s);

    }

}
