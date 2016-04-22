package com.amit.metric;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlets.MetricsServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;

/**
 * Created by amit on 22/4/16.
 */

@WebListener
@Component
public class MyMetricsServletContextListener extends MetricsServlet.ContextListener {


    public static final MetricRegistry METRIC_REGISTRY = new MetricRegistry();

    @Override
    protected MetricRegistry getMetricRegistry() {
        return METRIC_REGISTRY;
    }

}
