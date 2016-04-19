package com.amit.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by amit on 18/4/16.
 */

@Entity
@Table(name = "airport")
@Data
public class AirportMetaDataEntity implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "icao_code")
    private String icaoCode;
    @Column(name = "iata_code")
    private String iataCode;

    @Column(name = "airport_name")
    private  String airportName;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "lat_d")
    private Integer latitudeDegre;

    @Column(name = "lat_m")
    private Integer latitudeMinutes;

    @Column(name = "lat_s")
    private Integer latitudeSeconds;

    @Column(name = "lat_direction")
    private String latitudeDirection;

    @Column(name = "long_d")
    private Integer longitudeDegre;

    @Column(name = "long_m")
    private Integer longitudeMinutes;

    @Column(name = "long_s")
    private Integer longitudeSeconds;

    @Column(name = "long_direction")
    private String longitudeDirection;

    @Column(name = "altitude")
    private String altitude;




}
