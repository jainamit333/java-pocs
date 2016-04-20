package com.amit.metric;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * Created by amit on 19/4/16.
 */

@Component
public class MetricRegisteryInstance {

    MetricRegistry metricRegistry;

    @PostConstruct
    public void initMetricRegistry(){
        metricRegistry = new MetricRegistry();
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metricRegistry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(1, TimeUnit.SECONDS);

    }


    public MetricRegistry getMetricRegistry(){
        return  metricRegistry;
    }

}
