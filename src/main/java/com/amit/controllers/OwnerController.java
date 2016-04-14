package com.amit.controllers;

import com.amit.owner.PlainServerConfig;
import com.amit.owner.ServerConfig;
import com.amit.owner.SystemEnvProperties;
import org.aeonbits.owner.ConfigFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * Created by amit on 14/4/16.
 */

@RestController
@RequestMapping("owner")
public class OwnerController {


    @RequestMapping("test")
    public String ownerTest() {
        ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
        return cfg.hostname() + " - " + cfg.port() + "\n" + " - " + cfg.prop1() + "\n" + cfg.prop2();
    }

    @RequestMapping("from/prop")
    public String fromProperty() {

        Properties props = new Properties();
        props.setProperty("foo", "pineapple");
        props.setProperty("bar", "lime");
        PlainServerConfig serverConfig = ConfigFactory.create(PlainServerConfig.class, props);
        return serverConfig.bar();

    }


    @RequestMapping("systemprop")
    public String stsemEnvProperties() {
        SystemEnvProperties cfg = ConfigFactory.create(SystemEnvProperties.class, System.getProperties(), System.getenv());
        return cfg.javaHome() + "  --  " + cfg.user();
    }

}