package com.example.bootcamp.adapters.driving.http.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import com.example.bootcamp.adapters.driving.http.dtos.response.CapacityResponse;
import com.example.bootcamp.adapters.driving.http.dtos.response.TechnologyInCapabilities;
import com.example.bootcamp.domain.model.Capacity;
import com.example.bootcamp.domain.model.Technology;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICapacityResponseMapper {

    @Mapping(source = "id", target = "id") 
    @Mapping(source = "name", target = "name") 
    CapacityResponse toResponse(Capacity capacity);

    @Mapping(source = "id", target = "id") 
    @Mapping(source = "name", target = "name") 
    TechnologyInCapabilities mapTechnology(Technology technology);

    default List<TechnologyInCapabilities> mapTechnologies(List<Technology> technologies) {
        return technologies.stream().map(this::mapTechnology).collect(Collectors.toList());
    }

    default List<CapacityResponse> toResponseList(Page<Capacity> capacityPage){
        return capacityPage.getContent().stream()
                .map(capacity -> {
                    CapacityResponse response = toResponse(capacity);
                    response.setTechnologies(mapTechnologies(capacity.getTechnologies()));
                    return response;
                })
                .collect(Collectors.toList());
    } 

    
}
