package com.amit.controllers;

import com.amit.entity.AirportMetaDataEntity;
import com.amit.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by amit on 14/4/16.
 */

@RestController
public class HomeController {



    @Autowired
    AirportService airportService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String root(){
        return "I am Root ";
    }

    @RequestMapping("/test")
    public String test(){
        return "I am working ";
    }


//    @RequestMapping("load")
//    public String loadAirport() throws IOException {
//
//
//        Charset charset = Charset.forName("US-ASCII");
//        Path filePath = FileSystems.getDefault().getPath("/home/amit/Downloads/data", "data.txt");
//
//        BufferedReader bufferedReader = Files.newBufferedReader(filePath, charset);
//        String line = null;
//        while ((line = bufferedReader.readLine()) != null) {
//            String values[] = line.split(":");
//            AirportMetaDataEntity airportMetaDataEntity = new AirportMetaDataEntity();
//            airportMetaDataEntity.setIcaoCode(values[0]);
//            airportMetaDataEntity.setIataCode(values[1]);
//            airportMetaDataEntity.setAirportName(values[2]);
//            airportMetaDataEntity.setCity(values[3]);
//            airportMetaDataEntity.setCountry(values[4]);
//            airportMetaDataEntity.setLatitudeDegre(Integer.valueOf(values[5]));
//            airportMetaDataEntity.setLatitudeMinutes(Integer.valueOf(values[6]));
//            airportMetaDataEntity.setLatitudeSeconds(Integer.valueOf(values[7]));
//            airportMetaDataEntity.setLatitudeDirection(values[8]);
//            airportMetaDataEntity.setLongitudeDegre(Integer.valueOf(values[9]));
//            airportMetaDataEntity.setLongitudeMinutes(Integer.valueOf(values[10]));
//            airportMetaDataEntity.setLongitudeSeconds(Integer.valueOf(values[11]));
//            airportMetaDataEntity.setLongitudeDirection(values[12]);
//            airportMetaDataEntity.setAltitude(values[13]);
//
//
//            airportService.addNewAirport(airportMetaDataEntity);
//
//
//        }
//
//
//        return "DONE";
//    }

}
