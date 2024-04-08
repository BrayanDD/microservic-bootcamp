package com.example.bootcamp.domain.spi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.domain.model.Bootcamp;

public interface IBootcampPersistencePort {

    Long saveBootcamp(Bootcamp bootcamp);

    Page<Bootcamp> getAllBootcamp(Pageable pageable, Integer capacitiesCount);
}
