package com.amit.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;

import java.util.concurrent.TimeUnit;

/**
 * Created by amit on 22/4/16.
 */

@Controller
public class KafkaTestViaConfig {

//    @Autowired
//    private Listener listener;
//
//    @Autowired
//    private KafkaTemplate<Integer, String> template;
//
//    public void testKafka(){
//     //   waitListening("foo");
//        template.convertAndSend("annotated1", 0, "foo");
//      //  assertTrue(this.listener.latch1.await(10, TimeUnit.SECONDS));
//    }
}
