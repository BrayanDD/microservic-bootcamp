package com.example.bootcamp.adapters.driven.jpa.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyEntity;

import java.util.Optional;


public interface ITechnologyRepository extends JpaRepository<TechnologyEntity, Long> {

    Optional<TechnologyEntity> findByName(String technologyName);
}

