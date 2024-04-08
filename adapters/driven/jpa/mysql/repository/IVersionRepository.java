package com.example.bootcamp.adapters.driven.jpa.mysql.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.VersionEntity;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;

public interface IVersionRepository extends JpaRepository<VersionEntity, Long>{

    Optional<VersionEntity> findByBootcampIdAndVersion(Long bootcampId, String version);
    Page<VersionEntity> findByBootcampId(Long idBootcamp, Pageable pageable);
    
    Page<VersionEntity> findAllByMaxCapacityAndStartDate(Long maxCoup, LocalDate fechStar, Pageable pageable);
    Page<VersionEntity> findAllByMaxCapacity(Long maxCoup, Pageable pageable);
    Page<VersionEntity> findAllByStartDate(LocalDate fechStar, Pageable pageable);
}
