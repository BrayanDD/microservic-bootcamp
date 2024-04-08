package com.example.bootcamp.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.VersionEntity;
import com.example.bootcamp.adapters.driving.http.dtos.response.VersionResponse;
import com.example.bootcamp.domain.model.Version;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IVersionResponseMapper {

    VersionResponse toVersionResponse(Version version);

    Version toVersion(VersionEntity versionEntity);

    default List<VersionResponse> toResponseList(Page<Version> versionPage) {
        return versionPage.getContent().stream()
                .map(version -> {
                    VersionResponse response = toVersionResponse(version);
                    response.setBootcampName(version.getBootcampName()); 
                    return response;
                })
                .collect(Collectors.toList());
    }
}
