package com.example.bootcamp.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.bootcamp.adapters.driving.http.dtos.request.VersionRequest;
import com.example.bootcamp.domain.model.Version;



@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IVersionRequestMapper {

    Version toVersion(VersionRequest versionRequest);
}
