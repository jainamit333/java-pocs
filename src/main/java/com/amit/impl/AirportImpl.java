package com.amit.impl;

import com.amit.entity.AirportEntity;
import com.amit.repositories.AirportRepository;
import com.amit.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by amit on 14/4/16.
 */
@Controller
public class AirportImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public AirportEntity getAirportById(Long id) {
        return airportRepository.findById(id);
    }

    public void addNewAirport(AirportEntity airportEntity){
        airportRepository.save(airportEntity);
    }
}
