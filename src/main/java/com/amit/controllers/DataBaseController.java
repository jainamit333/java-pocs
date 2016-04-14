package com.amit.controllers;

import com.amit.entity.AirportEntity;
import com.amit.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by amit on 14/4/16.
 */

@RestController
@RequestMapping("sql")
public class DataBaseController {


    @Autowired
    AirportService airportService;

    @RequestMapping("test")
    public String testString(){
        return "testCOntroller";
    }

    @RequestMapping("get/{id}")
    public AirportEntity getById(@PathVariable Long id){
        return airportService.getAirportById(id);
    }


    @RequestMapping(value = "add/{code}/{country}/{name}",method = RequestMethod.GET,produces={"application/json"})
    public AirportEntity add(@PathVariable String code,@PathVariable String country,@PathVariable String name){
        AirportEntity airportEntity = new AirportEntity();
        airportEntity.setCode(code);
        airportEntity.setCountry(country);
        airportEntity.setName(name);
        airportService.addNewAirport(airportEntity);
        return airportEntity;

    }
}
