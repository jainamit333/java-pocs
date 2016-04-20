package com.amit.metric;

import com.codahale.metrics.annotation.Counted;
import com.codahale.metrics.annotation.Gauge;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by amit on 19/4/16.
 */

//@Component
public class AnnotationConsumer {

    @Gauge
    private Queue<Integer> simpleQueue = new LinkedList<Integer>();


    @Metered
    public String foo(){
        try {
            Thread.sleep(1*1000);
        }
        catch(InterruptedException e) {}
        return "foo";
    }


    @Metered(name = "customName request")
    public String fooWithName1(){
        try {
            Thread.sleep(1*1000);
        }
        catch(InterruptedException e) {}
        return "foo with name request";
    }


    @Metered(name = "customName response")
    public String fooWithName2(){
        try {
            Thread.sleep(1*1000);
        }
        catch(InterruptedException e) {}
        return "foo with name response";
    }

    public String callFoo(){
        return foo();
    }

    @Timed(name = "simple timer")
    public int getTimed(){
        try {
            Thread.sleep(5*1000);
        }
        catch(InterruptedException e) {}
        return 1;
    }

    public void addValueToQueue(){
        simpleQueue.add(1);
    }

    @Metered(name = "private method meter")
    private  String boo(){
        return "boo";
    }
    public String callPrivateBoo(){
        return boo();
    }



    @Counted
    public String counter(){
        return "counter called";
    }

}
