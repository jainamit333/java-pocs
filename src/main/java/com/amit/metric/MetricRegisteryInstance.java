package com.amit.metric;

import com.codahale.metrics.MetricRegistry;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by amit on 19/4/16.
 */

@Component
public class MetricRegisteryInstance {

    MetricRegistry metricRegistry;

    @PostConstruct
    public void initMetricRegistry(){
        metricRegistry = new MetricRegistry();
    }

}
