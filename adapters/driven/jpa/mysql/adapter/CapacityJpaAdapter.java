package com.example.bootcamp.adapters.driven.jpa.mysql.adapter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import com.example.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.example.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyInCapacity;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.CapacityAlreadyExistException;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.FaildGet;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.FaildSave;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.TechnologyIdNoExist;
import com.example.bootcamp.adapters.driven.jpa.mysql.mappers.CapacityEntityMapper;
import com.example.bootcamp.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import com.example.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyInCapacityRepocitory;
import com.example.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.example.bootcamp.domain.model.Capacity;
import com.example.bootcamp.domain.spi.ICapacityPersistencePort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CapacityJpaAdapter implements  ICapacityPersistencePort{

    private final ICapacityRepository capacityRepository;
    private final CapacityEntityMapper capacityEntityMapper;
    private final ITechnologyInCapacityRepocitory technologyInCapacityRepository;
    private final ITechnologyRepository technologyRepository;


    @Override
    public Page<Capacity> getAllCapacity(Pageable pageable, Integer technologiesCount) {
        Page<CapacityEntity> capacityEntityPage;
        if (pageable == null ) {
            throw new FaildGet();
        }
        if (technologiesCount != null) {
            capacityEntityPage = capacityRepository.findByTechnologiesCount(technologiesCount, pageable);
        } else {
            capacityEntityPage = capacityRepository.findAll(pageable);
        }

        if (capacityEntityPage.isEmpty()) {
            throw new NoDataFoundException();
        }

        return capacityEntityMapper.toCapacityList(capacityEntityPage);
    }


    @Override
    public Long saveCapacity(Capacity capacity) {
        if (capacityRepository.findByName(capacity.getName()).isPresent()) {
           throw new CapacityAlreadyExistException();

        }
       
        
        for (Long technology : capacity.getTechnologyIds()) {
            if (technology == null) {
                throw new FaildSave();
            }
            TechnologyEntity technologyEntity = technologyRepository.findById(technology).orElse(null);
        
            if (technologyEntity == null) {
                throw new TechnologyIdNoExist();
            } 

            
        }


        CapacityEntity entity = capacityEntityMapper.toEntity(capacity);
        if (entity == null) {
            throw new FaildSave();            
        }
        
        CapacityEntity savedEntity = capacityRepository.save(entity);

        for (Long technology : capacity.getTechnologyIds()) {
            if (technology == null) {
                throw new FaildSave();
            }
            TechnologyEntity technologyEntity = technologyRepository.findById(technology).orElse(null);
            
                TechnologyInCapacity technologyInCapacity = new TechnologyInCapacity();
                technologyInCapacity.setCapacity(savedEntity);
                technologyInCapacity.setTechnology(technologyEntity);
                technologyInCapacityRepository.save(technologyInCapacity);
            }

    
        return savedEntity.getId();
    }
    

}
