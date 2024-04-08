package com.example.bootcamp.adapters.driving.http.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.bootcamp.adapters.driving.http.dtos.request.BootcampRequest;
import com.example.bootcamp.domain.model.Bootcamp;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IBootcampRequestMapper {

    Bootcamp toBootcamp(BootcampRequest bootcampRequest);
}
