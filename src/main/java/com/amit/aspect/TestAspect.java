package com.amit.aspect;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by amit on 20/4/16.
 */
public class TestAspect {


    @Autowired
    CustomerBoImpl customerBo;

    public static void main(String[] args) {


        TestAspect testAspect = new TestAspect();
        testAspect.execute();

    }

    private void execute() {
        CustomerBo customerBo1 = new CustomerBoImpl();
            customerBo1.addCustomer();
    }
}
