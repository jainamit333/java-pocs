package com.amit.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by amit on 14/4/16.
 */

@Entity
@Table(name = "airport")
@Data
public class AirportEntity implements Serializable{


    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name="country")
    private String country;



}
