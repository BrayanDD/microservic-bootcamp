package com.example.bootcamp.domain.api.usecase;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.domain.api.ITechnologyServicePort;
import com.example.bootcamp.domain.model.Technology;
import com.example.bootcamp.domain.spi.ITechnologyPersistenPort;


public class TechnologyUseCase implements ITechnologyServicePort{
    
    private final ITechnologyPersistenPort iTechnologyPersistenPort;
    

    public TechnologyUseCase(ITechnologyPersistenPort iTechnologyPersistenPort) {
        this.iTechnologyPersistenPort = iTechnologyPersistenPort;
    }

    @Override
    public Long saveTechnology(Technology technology) {
       
       return iTechnologyPersistenPort.saveTechnology(technology);
       
    }

    @Override
    public Page<Technology> getAllTechnology(Pageable pageable) {
       
        return iTechnologyPersistenPort.getAllTechnology(pageable);
    }

    
    
}
