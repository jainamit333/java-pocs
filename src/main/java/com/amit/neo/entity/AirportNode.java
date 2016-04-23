package com.amit.neo.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * Created by amit on 19/4/16.
 */
@NodeEntity
public class AirportNode {


    @GraphId
    Long id;

    private String code;
}
