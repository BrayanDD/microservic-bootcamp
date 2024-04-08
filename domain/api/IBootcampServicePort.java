package com.example.bootcamp.domain.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bootcamp.domain.model.Bootcamp;

public interface IBootcampServicePort {

    Long saveBootcamp(Bootcamp bootcamp);

    Page<Bootcamp> getAllBootcamp(Pageable pageable, Integer capacitiesCount);
}
