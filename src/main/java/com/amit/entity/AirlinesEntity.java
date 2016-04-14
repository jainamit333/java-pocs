package com.amit.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by amit on 14/4/16.
 */
@Entity
@Table(name = "airline")
@Data
public class AirlinesEntity implements Serializable {


    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "provider")
    private String provider;

    @Column(name="active")
    private Boolean active;

}
