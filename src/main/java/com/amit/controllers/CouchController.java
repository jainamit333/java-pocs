package com.amit.controllers;

import com.amit.couch.document.User;
import com.amit.couch.service.CouchService;
import com.codahale.metrics.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * Created by amit on 9/5/16.
 */
@RestController
@RequestMapping("/couch")
public class CouchController {


    @Autowired
    CouchService couchService;

    @Timed
    @RequestMapping("add")
    public User addNewUser(){
        User user = new User();
        user.setId("new_id"+ Calendar.getInstance().getTime().toString());
        user.setFirstname("amit");
        user.setLastname("jain");
        return couchService.saveNewUser(user);

    }

    @Timed
    @RequestMapping("get")
    public User getUser(){
        return couchService.getUserById("new_idMon May 09 14:57:59 IST 2016");
    }

}
