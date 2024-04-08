package com.example.bootcamp.domain.api;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.domain.model.Technology;

public interface ITechnologyServicePort {

    Long saveTechnology(Technology technology);

    Page<Technology> getAllTechnology(Pageable pegeable);

    

    
}
