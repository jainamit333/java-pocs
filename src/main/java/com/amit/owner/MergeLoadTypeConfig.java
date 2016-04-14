package com.amit.owner;

import org.aeonbits.owner.Config;

/**
 * Created by amit on 14/4/16.
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:ServerConfigDefault.properties","classpath:ServerConfig.properties"})
public interface MergeLoadTypeConfig extends Config{

    @DefaultValue("989")
    int port();

    @DefaultValue("default")
    @Key("byKey")
    String hostname();


    @DefaultValue("1")
    int maxThreads();

    @Config.DefaultValue("prop1 coming from default")
    String prop1();

    @Config.DefaultValue("prop2 coming from default")
    String prop2();
}
