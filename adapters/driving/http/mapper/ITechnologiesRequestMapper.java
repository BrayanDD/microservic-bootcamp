package com.example.bootcamp.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.bootcamp.adapters.driving.http.dtos.request.TechnologiesRequest;
import com.example.bootcamp.domain.model.Technology;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITechnologiesRequestMapper {
    Technology toTechnology(TechnologiesRequest technologyRequest);
}
        