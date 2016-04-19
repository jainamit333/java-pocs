package com.amit.neo.service;

import com.amit.neo.entity.AirportNode;
import java.util.List;

/**
 * Created by amit on 19/4/16.
 */
public interface AiportNeoService {

    AirportNode create(AirportNode profile);
    void delete(AirportNode profile);
    AirportNode findById(long id);
    List<AirportNode> findAll();
}
