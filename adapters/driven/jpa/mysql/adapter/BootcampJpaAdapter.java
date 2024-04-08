package com.example.bootcamp.adapters.driven.jpa.mysql.adapter;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;
import com.example.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import com.example.bootcamp.adapters.driven.jpa.mysql.entity.CapacityInBootcamp;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.BootcampAlreadyExist;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.CapacityIdNoExist;

import com.example.bootcamp.adapters.driven.jpa.mysql.exception.FaildGet;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.FaildSave;
import com.example.bootcamp.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.example.bootcamp.adapters.driven.jpa.mysql.mappers.BootcampEntityMapper;
import com.example.bootcamp.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import com.example.bootcamp.adapters.driven.jpa.mysql.repository.ICapacityInBootcampRepository;
import com.example.bootcamp.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import com.example.bootcamp.domain.model.Bootcamp;
import com.example.bootcamp.domain.spi.IBootcampPersistencePort;



import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BootcampJpaAdapter implements IBootcampPersistencePort {
    
    private final IBootcampRepository bootcampRepository;
    private final BootcampEntityMapper bootcampEntityMapper;
    private final ICapacityInBootcampRepository capacityInBootcampRepository;
    private final ICapacityRepository capacityRepository;
    
    
    @Override
    public Page<Bootcamp> getAllBootcamp(Pageable pageable, Integer capacitiesCount) {
        Page<BootcampEntity> bootcampEntityPage;
        if (pageable == null) {
                    throw new FaildGet();
        }
        if (capacitiesCount != null) {
            bootcampEntityPage = bootcampRepository.findByCapacitiesCount(capacitiesCount, pageable);
        } else {
            bootcampEntityPage = bootcampRepository.findAll(pageable);
        }

        if (bootcampEntityPage.isEmpty()) {
            throw new NoDataFoundException();
        }

        return bootcampEntityMapper.toBootcampList(bootcampEntityPage);
    }


    @Override
    public Long saveBootcamp(Bootcamp bootcamp) {
        if (bootcampRepository.findByName(bootcamp.getName()).isPresent()) {
            throw new BootcampAlreadyExist();
        }

        for (Long capcity : bootcamp.getCapacitiesIds()) {
            if (capcity == null) {
                throw new FaildSave();
            }
            CapacityEntity capacityEntity = capacityRepository.findById(capcity).orElse(null);

            if (capacityEntity == null) {
                throw new CapacityIdNoExist();
            }

           

        }

        BootcampEntity bootcampEntity = bootcampEntityMapper.toEntity(bootcamp);
        if (bootcampEntity == null) {
            throw new FaildSave();            
        }
        BootcampEntity savedBootcamp = bootcampRepository.save(bootcampEntity);

        for (Long capacity : bootcamp.getCapacitiesIds()) {
            if (capacity == null) {
                throw new FaildSave();
            }
            CapacityEntity capacityEntity = capacityRepository.findById(capacity).orElse(null);
         
            CapacityInBootcamp capacityInBootcamp = new CapacityInBootcamp();
            capacityInBootcamp.setBootcampEntity(savedBootcamp);
            capacityInBootcamp.setCapacity(capacityEntity);
            capacityInBootcampRepository.save(capacityInBootcamp);
        }


        return savedBootcamp.getId();
    }

}
