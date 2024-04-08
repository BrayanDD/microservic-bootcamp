package com.example.bootcamp.domain.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.domain.model.Capacity;

public interface ICapacityServicePort {

    Long saveCapacity(Capacity capacity);

    Page<Capacity> getAllCapacity(Pageable pageable, Integer technologiesCount);

}
