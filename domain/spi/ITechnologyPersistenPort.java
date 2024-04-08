package com.example.bootcamp.domain.spi;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.domain.model.Technology;

public interface ITechnologyPersistenPort {

    Long saveTechnology(Technology technology);

    Page<Technology> getAllTechnology(Pageable pageable);
    
}