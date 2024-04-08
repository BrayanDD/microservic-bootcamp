package com.example.bootcamp.adapters.driven.jpa.mysql.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.example.bootcamp.domain.model.Technology;




@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE,
unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TechnologyEntityMapper {

    TechnologyEntity toEntity(Technology technology);

    Technology toTechnology(TechnologyEntity technologyEntity);
    
    default Page<Technology> toTechnologyList(Page<TechnologyEntity> technologyEntityPage) {
        return technologyEntityPage.map(this::toTechnology);
    }
}
