package com.amit.controllers;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amit on 3/5/16.
 */
@RestController
@RequestMapping("/websocket")
public class WebSocketController {


    @RequestMapping("test")
    @SendTo("/topic/greeting")
    public String test() throws InterruptedException {
        Thread.sleep(3000l);
        return "test me";
    }
}
