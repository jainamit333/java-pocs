package com.amit.metric;

import com.codahale.metrics.annotation.Metered;
import com.codahale.metrics.annotation.Timed;
import org.springframework.stereotype.Component;

/**
 * Created by amit on 20/4/16.
 */
@Component
public class DummyResponseAdapter extends DummyParent{

    @Override
    public String map(String in) {
        return "1";
    }
}
