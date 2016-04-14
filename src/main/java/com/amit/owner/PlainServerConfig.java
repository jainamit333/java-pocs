package com.amit.owner;

import org.aeonbits.owner.Config;

/**
 * Created by amit on 14/4/16.
 */
public interface PlainServerConfig extends Config{

    @Config.DefaultValue("apple")
    String foo();

    @Config.DefaultValue("pear")
    String bar();

    @Config.DefaultValue("orange")
    String baz();
}
