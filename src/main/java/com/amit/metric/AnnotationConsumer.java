package com.amit.metric;

import com.codahale.metrics.annotation.Metered;
import org.springframework.stereotype.Component;

/**
 * Created by amit on 19/4/16.
 */

@Component
public class AnnotationConsumer {

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
}
