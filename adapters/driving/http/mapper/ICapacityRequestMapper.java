package com.example.bootcamp.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.bootcamp.adapters.driving.http.dtos.request.CapacityRequest;
import com.example.bootcamp.domain.model.Capacity;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICapacityRequestMapper {

    Capacity toCapacity(CapacityRequest capacityRequest);

}
