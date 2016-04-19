package com.amit.neo.repositories;

import com.amit.neo.entity.AirportNode;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by amit on 19/4/16.
 */
public interface AirportNeoRepository extends GraphRepository<AirportNode>{

}
