package com.example.bootcamp.adapters.driven.jpa.mysql.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;

public interface IBootcampRepository extends JpaRepository<BootcampEntity, Long> {

    Optional<BootcampEntity> findByName(String bootcampName);

    @Query("SELECT b FROM BootcampEntity b WHERE SIZE(b.capacities) = :capacitiesCount")
    Page<BootcampEntity> findByCapacitiesCount(int capacitiesCount, Pageable pageable);
}

