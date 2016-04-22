package com.amit.metric;

import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.servlets.HealthCheckServlet;

import javax.servlet.annotation.WebListener;

/**
 * Created by amit on 22/4/16.
 */
@WebListener
public class MyHealthCheckServletContextListener extends HealthCheckServlet.ContextListener {

    public static final HealthCheckRegistry HEALTH_CHECK_REGISTRY = new HealthCheckRegistry();

    @Override
    protected HealthCheckRegistry getHealthCheckRegistry() {
        return HEALTH_CHECK_REGISTRY;
    }

}
