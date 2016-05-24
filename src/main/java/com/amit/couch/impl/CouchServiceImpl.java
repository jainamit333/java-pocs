package com.amit.couch.impl;

import com.amit.couch.document.User;
import com.amit.couch.repositories.UserRepository;
import com.amit.couch.service.CouchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by amit on 9/5/16.
 */
@Component
public class CouchServiceImpl implements CouchService{

    @Autowired
    UserRepository  userRepository;

    @Override
    public User saveNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findOne(id);
    }
}
