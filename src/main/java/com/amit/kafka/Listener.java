package com.amit.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by amit on 22/4/16.
 */
@Component
public class Listener {

//    private final CountDownLatch latch1 = new CountDownLatch(1);
//
//    @KafkaListener(id = "foo", topics = "annotated1")
//    public void listen1(String foo) {
//        this.latch1.countDown();
//    }
}
