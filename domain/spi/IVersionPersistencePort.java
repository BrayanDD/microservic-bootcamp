package com.example.bootcamp.domain.spi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.domain.model.Version;

import java.time.LocalDate;
public interface IVersionPersistencePort {

    Long saveVersion(Version version);

    Page<Version> getAllVersions(Pageable pageable,Long maxCoup,LocalDate fechStar,Long idBootcamp);
}
