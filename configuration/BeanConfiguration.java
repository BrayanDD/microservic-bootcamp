package com.example.bootcamp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.bootcamp.adapters.driven.jpa.mysql.adapter.BootcampJpaAdapter;
import com.example.bootcamp.adapters.driven.jpa.mysql.adapter.CapacityJpaAdapter;
import com.example.bootcamp.adapters.driven.jpa.mysql.adapter.TechnologyJpaAdapter;
import com.example.bootcamp.adapters.driven.jpa.mysql.adapter.VersionJpaApadter;
import com.example.bootcamp.adapters.driven.jpa.mysql.mappers.BootcampEntityMapper;
import com.example.bootcamp.adapters.driven.jpa.mysql.mappers.CapacityEntityMapper;
import com.example.bootcamp.adapters.driven.jpa.mysql.mappers.TechnologyEntityMapper;
import com.example.bootcamp.adapters.driven.jpa.mysql.mappers.VersionEntityMapper;
import com.example.bootcamp.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import com.example.bootcamp.adapters.driven.jpa.mysql.repository.ICapacityInBootcampRepository;
import com.example.bootcamp.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import com.example.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyInCapacityRepocitory;
import com.example.bootcamp.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.example.bootcamp.adapters.driven.jpa.mysql.repository.IVersionRepository;
import com.example.bootcamp.domain.api.IBootcampServicePort;
import com.example.bootcamp.domain.api.ICapacityServicePort;
import com.example.bootcamp.domain.api.ITechnologyServicePort;
import com.example.bootcamp.domain.api.IVersionServicePort;
import com.example.bootcamp.domain.api.usecase.BootcampUseCase;
import com.example.bootcamp.domain.api.usecase.CapacityUseCase;
import com.example.bootcamp.domain.api.usecase.TechnologyUseCase;
import com.example.bootcamp.domain.api.usecase.VersionUseCase;
import com.example.bootcamp.domain.spi.IBootcampPersistencePort;
import com.example.bootcamp.domain.spi.ICapacityPersistencePort;
import com.example.bootcamp.domain.spi.ITechnologyPersistenPort;
import com.example.bootcamp.domain.spi.IVersionPersistencePort;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ITechnologyRepository technologyRepository;
    private final TechnologyEntityMapper technologyEntityMapper;

    
    private final ICapacityRepository capacityRepository;
    private final CapacityEntityMapper capacityEntityMapper;
    private final ITechnologyInCapacityRepocitory technologyInCapacityRepocitory;


    private final IBootcampRepository bootcampRepository;
    private final BootcampEntityMapper bootcampEntityMapper;
    private final ICapacityInBootcampRepository capacityInBootcampRepository;


    private final IVersionRepository versionRepository;
    private final VersionEntityMapper versionEntityMapper;

    //Technology
    
    @Bean 
    public ITechnologyPersistenPort technologyPersistenPort(){
        return new TechnologyJpaAdapter(technologyRepository, technologyEntityMapper);
    }

    @Bean
    public ITechnologyServicePort technologyServicePort(){
        return new TechnologyUseCase(technologyPersistenPort());
    }

    /////////////////////////

    //Capacity
    @Bean 
    public ICapacityPersistencePort capacityPersistencePort(){
        return new CapacityJpaAdapter(capacityRepository, capacityEntityMapper,technologyInCapacityRepocitory, technologyRepository);
    }

    @Bean
    public ICapacityServicePort capacityServicePort(){
        return new CapacityUseCase(capacityPersistencePort());
    }
    
    ////////////////////////

    //Bootcamp
    
    @Bean
    public IBootcampPersistencePort bootcampPersistencePort(){
        return new BootcampJpaAdapter(bootcampRepository,bootcampEntityMapper,capacityInBootcampRepository,capacityRepository);
    }

    @Bean
    public IBootcampServicePort bootcampServicePort(){
        return new BootcampUseCase(bootcampPersistencePort());
    }

    ////////////////////////////////////////

    //Version

    @Bean IVersionPersistencePort versionPersistencePort(){
        return new VersionJpaApadter(versionEntityMapper, versionRepository);
    }

    @Bean IVersionServicePort versionServicePort(){
        return new VersionUseCase(versionPersistencePort());
    }
}

