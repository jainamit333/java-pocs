package com.amit.repositories;

import com.amit.entity.AirlinesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by amit on 14/4/16.
 */
public interface AirlineRepository extends JpaRepository<AirlinesEntity,Integer>{

    AirlinesEntity findById(Long id);
}
