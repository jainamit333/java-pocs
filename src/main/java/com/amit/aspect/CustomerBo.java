package com.amit.aspect;

/**
 * Created by amit on 20/4/16.
 */
public interface CustomerBo {


    void addCustomer();

    String addCustomerReturnValue();

    void addCustomerThrowException() throws Exception;

    void addCustomerAround(String name);
}
