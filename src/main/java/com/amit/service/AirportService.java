package com.amit.service;

import com.amit.entity.AirportEntity;
import com.amit.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by amit on 14/4/16.
 */

public interface AirportService {

     AirportEntity getAirportById(Long id);

     void addNewAirport(AirportEntity airportEntity);



}
