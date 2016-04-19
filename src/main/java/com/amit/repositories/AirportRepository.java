package com.amit.repositories;

/**
 * Created by amit on 14/4/16.
 */


import com.amit.entity.AirportMetaDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<AirportMetaDataEntity,Integer> {


    AirportMetaDataEntity findById(Long id);

    AirportMetaDataEntity findByIataCode(String s);

}
