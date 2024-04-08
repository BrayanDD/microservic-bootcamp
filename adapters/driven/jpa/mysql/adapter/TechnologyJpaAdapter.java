package com.example.bootcamp.adapters.driven.jpa.mysql.adapter;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.FaildGet;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.FaildSave;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.TechnologyAlreadyExistException;
import com.example.bootcamp.adapters.driven.jpa.mysql.mappers.TechnologyEntityMapper;
import com.example.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.example.bootcamp.domain.model.Technology;
import com.example.bootcamp.domain.spi.ITechnologyPersistenPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TechnologyJpaAdapter implements ITechnologyPersistenPort {

    private final ITechnologyRepository technologyRepository;
    
    private final TechnologyEntityMapper technologyEntityMapper;

    @Override
    public Page<Technology> getAllTechnology(Pageable pageable) {
        if (pageable.equals(null)) {
            throw new FaildGet();
        }
        Page<TechnologyEntity> technologyEntityList = technologyRepository.findAll(pageable);
        if(technologyEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return technologyEntityMapper.toTechnologyList(technologyEntityList);
    }

    @Override
    public Long saveTechnology(Technology technology) {
        if (technologyRepository.findByName(technology.getName()).isPresent()) {
            throw new TechnologyAlreadyExistException();
        }
        
        TechnologyEntity entity = technologyEntityMapper.toEntity(technology);
        if (entity.equals(null)) {
            throw new FaildSave();            
        }
        TechnologyEntity savedEntity = technologyRepository.save(entity);
        

        return savedEntity.getId();
    }
}
