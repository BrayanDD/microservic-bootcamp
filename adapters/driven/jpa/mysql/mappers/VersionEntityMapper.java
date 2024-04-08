package com.example.bootcamp.adapters.driven.jpa.mysql.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.VersionEntity;
import com.example.bootcamp.domain.model.Version;

@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.IGNORE,
unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface VersionEntityMapper {

    VersionEntity toEntity(Version version);

    Version toVersion(VersionEntity versionEntity);

    default Page<Version> toVersionList(Page<VersionEntity> versionEntityPage){
        return versionEntityPage.map(versionEntity -> {
            Version version = toVersion(versionEntity);
            version.setBootcampName(versionEntity.getBootcamp().getName());
            return version;
        });
    }
}
