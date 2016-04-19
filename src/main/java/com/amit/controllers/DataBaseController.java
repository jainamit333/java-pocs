package com.amit.controllers;


import com.amit.entity.AirportMetaDataEntity;
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
    public AirportMetaDataEntity getById(@PathVariable Long id){
        return airportService.getAirportById(id);
    }

    @RequestMapping("get/code/{id}")
    @ResponseBody
    public AirportMetaDataEntity getByCode(@PathVariable String id){
        return airportService.getAirportByCode(id);
    }


}
