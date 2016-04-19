package com.amit.service;


import com.amit.entity.AirportMetaDataEntity;
import com.amit.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by amit on 14/4/16.
 */

public interface AirportService {

     AirportMetaDataEntity getAirportById(Long id);

     AirportMetaDataEntity getAirportByCode(String s);

     void addNewAirport(AirportMetaDataEntity airportEntity);



}
