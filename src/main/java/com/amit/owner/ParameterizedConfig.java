package com.amit.owner;

import org.aeonbits.owner.Config;

/**
 * Created by amit on 15/4/16.
 */
public interface ParameterizedConfig extends Config{

    @DefaultValue("Hello Mr. %s!")
    String helloMr(String name);

    @DisableFeature(DisableableFeature.PARAMETER_FORMATTING)
    @DefaultValue("Hello Mr. %s!")
    String helloMrDisabled(String name);

}
