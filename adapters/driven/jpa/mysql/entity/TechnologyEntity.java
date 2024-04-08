package com.example.bootcamp.adapters.driven.jpa.mysql.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;
import javax.validation.constraints.Size;

import java.util.Set;
import java.util.HashSet;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Table(name = "technology")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Size(max = 50, message = "The name cannot exceed 50 characters")
    private String name;

    @Size(max = 90, message = "The description cannot exceed 90 characters")
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "technologies")
    private Set<CapacityEntity> capacities = new HashSet<>();
}

