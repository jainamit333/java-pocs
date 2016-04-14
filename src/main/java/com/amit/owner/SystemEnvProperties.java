package com.amit.owner;

import org.aeonbits.owner.Config;

/**
 * Created by amit on 14/4/16.
 */
public interface SystemEnvProperties extends Config {

    @Key("file.separator")
    String fileSeparator();

    @Key("java.home")
    String javaHome();

    @Key("HOME")
    String home();

    @Key("USER")
    String user();
}
