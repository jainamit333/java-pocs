package com.amit.owner;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Reloadable;

/**
 * Created by amit on 15/4/16.
 */
@Config.Sources("classpath:ServerConfig.properties")
public interface ReloadableConfig extends Reloadable {

    @Config.DefaultValue("prop1 coming from default")
    String prop1();
}
