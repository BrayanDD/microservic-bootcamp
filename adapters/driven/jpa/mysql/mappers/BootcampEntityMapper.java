package com.example.bootcamp.adapters.driven.jpa.mysql.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;
import com.example.bootcamp.domain.model.Bootcamp;


@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE,
unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BootcampEntityMapper {

    BootcampEntity toEntity(Bootcamp bootcamp);

    Bootcamp toBootcamp(BootcampEntity bootcampEntity);

    default Page<Bootcamp> toBootcampList(Page<BootcampEntity> bootcampEntityList){
        return bootcampEntityList.map(this::toBootcamp);
    }
}
