package com.amit.metric;

import com.amit.annotations.SimpleAnnotation;
import com.codahale.metrics.annotation.Counted;
import com.codahale.metrics.annotation.Gauge;
import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;

/**
 * Created by amit on 20/4/16.
 */

public  class DummyParent {


//    @Timed
//    @Gauge
//    @Metered
//    @Counted
//
   public  String  map(String in){
        return "parent";
    }
}
