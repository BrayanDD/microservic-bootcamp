package com.example.bootcamp.domain.spi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.domain.model.Capacity;



public interface ICapacityPersistencePort {

    Long saveCapacity(Capacity capacity);

    Page<Capacity> getAllCapacity(Pageable pageable, Integer technologiesCount);

}
