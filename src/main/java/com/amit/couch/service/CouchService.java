package com.amit.couch.service;

import com.amit.couch.document.User;

/**
 * Created by amit on 9/5/16.
 */
public interface CouchService {

    public User saveNewUser(User user);

    public User getUserById(String id);

}
