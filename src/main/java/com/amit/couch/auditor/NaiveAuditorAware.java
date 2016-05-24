package com.amit.couch.auditor;

import org.springframework.data.domain.AuditorAware;

/**
 * Created by amit on 9/5/16.
 */
public class NaiveAuditorAware implements AuditorAware<String> {

    private String auditor = "auditor";

    @Override
    public String getCurrentAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }


}
