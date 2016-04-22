package com.amit.aspect;

import com.amit.metric.MetricRegisteryInstance;
import com.codahale.metrics.Meter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by amit on 20/4/16.
 */

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private MetricRegisteryInstance metricRegistry;

    @Before("execution(* com.amit.aspect.CustomerBo.addCustomer())")
    public void logAfter(JoinPoint joinPoint) {

        Meter requests = metricRegistry.getMetricRegistry().meter(joinPoint.getSignature().toString());
        requests.mark();
    }

}
