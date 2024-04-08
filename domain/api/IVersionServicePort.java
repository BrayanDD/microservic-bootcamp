package com.example.bootcamp.domain.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.domain.model.Version;

import java.time.LocalDate;
public interface IVersionServicePort {

    Long saveVersion(Version version);

    Page<Version> getAllVersions(Pageable pageable,Long maxCoup,LocalDate fechStar, Long idBootcamp);
}
