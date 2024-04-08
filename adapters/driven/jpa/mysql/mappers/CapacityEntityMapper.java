package com.example.bootcamp.adapters.driven.jpa.mysql.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;
import com.example.bootcamp.domain.model.Capacity;

@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE,
unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CapacityEntityMapper {

    CapacityEntity toEntity(Capacity capacity);

    Capacity toCapacity(CapacityEntity capacityEntity);

    default Page<Capacity> toCapacityList(Page<CapacityEntity> capacityEntityList){
        return capacityEntityList.map(this::toCapacity);
    }
}
