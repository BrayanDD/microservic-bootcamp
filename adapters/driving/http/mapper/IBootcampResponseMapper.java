package com.example.bootcamp.adapters.driving.http.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.CapacityInBootcamp;
import com.example.bootcamp.adapters.driving.http.dtos.response.BootcampResponse;
import com.example.bootcamp.adapters.driving.http.dtos.response.TechnologyInCapabilities;
import com.example.bootcamp.domain.model.Bootcamp;
import com.example.bootcamp.domain.model.Capacity;
import com.example.bootcamp.domain.model.Technology;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IBootcampResponseMapper {

    @Mapping(source = "id", target = "id") 
    @Mapping(source = "name", target = "name") 
    @Mapping(source = "description", target = "description") 
    BootcampResponse toResponse(Bootcamp bootcamp);

    @Mapping(source = "id", target = "capacity.id") 
    @Mapping(source = "name", target = "capacity.name") 
    CapacityInBootcamp mapCapacity(Capacity capacity);

    @Mapping(source = "id", target = "id") 
    @Mapping(source = "name", target = "name") 
    TechnologyInCapabilities mapTechnology(Technology technology);

    default List<TechnologyInCapabilities> mapTechnologies(List<Technology> technologies) {
        return technologies.stream().map(this::mapTechnology).collect(Collectors.toList());
    }
    
    default List<CapacityInBootcamp> mapCapacities(List<Capacity> capacities) {
        return capacities.stream()
                .map(this::mapCapacity)
                .collect(Collectors.toList());
    }

    default List<BootcampResponse> toResponseList(Page<Bootcamp> bootcampPage){
        return bootcampPage.getContent().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

   
}
