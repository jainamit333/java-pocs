package com.amit.couch.repositories;

import com.amit.couch.document.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by amit on 9/5/16.
 */
@Repository
public interface UserRepository extends CouchbaseRepository<User,String> {
}
