package com.example.bootcamp.adapters.driven.jpa.mysql.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.CapacityEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICapacityRepository extends JpaRepository<CapacityEntity, Long> {

    Optional<CapacityEntity> findByName(String capacityName);

    @Query("SELECT c FROM CapacityEntity c WHERE SIZE(c.technologies) = :technologiesCount")
    Page<CapacityEntity> findByTechnologiesCount(int technologiesCount, Pageable pageable);
}

