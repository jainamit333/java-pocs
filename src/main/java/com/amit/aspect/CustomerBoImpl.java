package com.amit.aspect;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by amit on 20/4/16.
 */

@Service
public class CustomerBoImpl implements CustomerBo {

    public void addCustomer(){
        System.out.println("addCustomer() is running ");
    }

    public String addCustomerReturnValue(){
        System.out.println("addCustomerReturnValue() is running ");
        return "abc";
    }

    public void addCustomerThrowException() throws Exception {
        System.out.println("addCustomerThrowException() is running ");
        throw new Exception("Generic Error");
    }

    public void addCustomerAround(String name){
        System.out.println("addCustomerAround() is running, args : " + name);
    }
}
