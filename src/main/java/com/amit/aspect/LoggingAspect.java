package com.amit.aspect;

import com.amit.metric.MetricRegisteryInstance;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.Timer;
import org.apache.taglibs.standard.functions.Functions;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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



    @Around("execution(* com.amit.aspect.CustomerBo.addCustomer())")
    public void timeIt(ProceedingJoinPoint joinPoint) {


//
//
//        Meter requests1 = metricRegistry.getMetricRegistry().meter(joinPoint.getSignature().toString()+" meter");
//        requests1.mark();


        Timer requests = metricRegistry.getMetricRegistry().timer(joinPoint.getSignature().toString()+" timer");
        Timer.Context abc = requests.time();

        try {
            joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        abc.close();

    }
}
