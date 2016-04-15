package com.amit.owner;

import org.aeonbits.owner.Config;

/**
 * Created by amit on 15/4/16.
 */
@Config.HotReload
@Config.Sources("classpath:ServerConfig.properties")
public interface AutoReloadConfig extends Config{

    
    @DefaultValue("989")
    String port();
}
