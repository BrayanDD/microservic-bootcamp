package com.example.bootcamp.adapters.driving.http.mapper;

import org.springframework.data.domain.Page;

import com.example.bootcamp.adapters.driving.http.dtos.response.TechnologiesResponse;
import com.example.bootcamp.domain.model.Technology;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITechnologiesResponseMapper {

    @Mapping(source = "id", target = "id") 
    @Mapping(source = "name", target = "name") 
    @Mapping(source = "description", target = "description") 
    TechnologiesResponse toResponse(Technology technology);
    
    default List<TechnologiesResponse> toResponseList(Page<Technology> technologyPage) {
        return technologyPage.getContent().stream()
                                          .map(this::toResponse)
                                          .collect(Collectors.toList());
    }
    
}
