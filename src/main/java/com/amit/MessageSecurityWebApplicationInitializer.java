package com.amit;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by amit on 15/4/16.
 */
@Order(value = 1)
public class MessageSecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public MessageSecurityWebApplicationInitializer() {
        super(SecurityConfig.class);
    }
}
