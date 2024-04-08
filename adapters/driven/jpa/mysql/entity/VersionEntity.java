package com.example.bootcamp.adapters.driven.jpa.mysql.entity;

import java.time.LocalDate;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "version")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VersionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @NotNull(message = "The version number cannot be null")
    private String version;

    @NotNull(message = "The idBootcamp field cannot be null")
    private Long idBootcamp;

    @NotNull(message = "The start date cannot be null")
    private LocalDate startDate;

    @NotNull(message = "The end date cannot be null")
    private LocalDate endDate;

    @NotNull(message = "The max capacity cannot be null")
    private Long maxCapacity; 


    @ManyToOne
    @JoinColumn(name = "idBootcamp", referencedColumnName = "id", insertable = false, updatable = false) 
    private BootcampEntity bootcamp;
}
