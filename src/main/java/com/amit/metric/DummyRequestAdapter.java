package com.amit.metric;

import org.springframework.stereotype.Component;

/**
 * Created by amit on 20/4/16.
 */

@Component
public class DummyRequestAdapter extends DummyParent {

    @Override
    public String map(String in) {
        return "Dummy Request Adapter";
    }
}
