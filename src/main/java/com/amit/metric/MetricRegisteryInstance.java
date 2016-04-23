package com.amit.metric;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * Created by amit on 19/4/16.
 */

@Component
public class MetricRegisteryInstance {

    //private  MetricRegistry metricRegistry;
    @Autowired
    MyMetricsServletContextListener myMetricsServletContextListener;

    @PostConstruct
    public void initMetricRegistry(){

//        ConsoleReporter reporter = ConsoleReporter.forRegistry(myMetricsServletContextListener.getMetricRegistry())
//                .convertRatesTo(TimeUnit.SECONDS)
//                .convertDurationsTo(TimeUnit.MILLISECONDS)
//                .build();
//        reporter.start(1, TimeUnit.SECONDS);

    }


    public MetricRegistry getMetricRegistry(){
        return  myMetricsServletContextListener.getMetricRegistry();
    }

}
