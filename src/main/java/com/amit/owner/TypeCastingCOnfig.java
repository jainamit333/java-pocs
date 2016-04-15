package com.amit.owner;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.DefaultValue;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by amit on 15/4/16.
 */
public interface TypeCastingCOnfig extends Config{

    @DefaultValue("3.1415")
    double pi();

    @DefaultValue("NANOSECONDS")
    TimeUnit timeUnit();

    @DefaultValue("apple, pear, orange")
    public String[] fruit();

    @Separator(";")
    @DefaultValue("0; 1; 1; 2; 3; 5; 8; 13; 21; 34; 55")
    public int[] fibonacci();

    @DefaultValue("1, 2, 3, 4")
    List<Integer> ints();




}
