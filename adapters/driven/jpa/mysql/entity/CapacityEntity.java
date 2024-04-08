package com.example.bootcamp.adapters.driven.jpa.mysql.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import java.util.ArrayList;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "capacity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CapacityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The capacity name cannot be empty")
    @Size(max = 50, message = "The maximum name length is 50 characters")
    private String name;
    
    @NotEmpty(message = "The capacity description cannot be empty")
    @Size(max = 90, message = "The maximum description length is 90 characters")
    private String description;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "technology_in_capacity",
            joinColumns = @JoinColumn(name = "capacity_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id"))
    private List<TechnologyEntity> technologies = new ArrayList<>();
}
