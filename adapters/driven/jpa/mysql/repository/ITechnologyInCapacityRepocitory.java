package com.example.bootcamp.adapters.driven.jpa.mysql.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootcamp.adapters.driven.jpa.mysql.entity.TechnologyInCapacity;

public interface ITechnologyInCapacityRepocitory extends JpaRepository<TechnologyInCapacity,Long> {

    Optional<TechnologyInCapacity> findByCapacityId(Long capacityId);
}

