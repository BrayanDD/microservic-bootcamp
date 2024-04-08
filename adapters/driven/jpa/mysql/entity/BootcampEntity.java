package com.example.bootcamp.adapters.driven.jpa.mysql.entity;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bootcamp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BootcampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The bootcamp name cannot be empty")
    @Size(max = 50, message = "The maximum name length is 50 characters")
    private String name;

    @NotNull(message = "The bootcamp description cannot be empty")
    @Size(max = 50, message = "The maximum name length is 50 characters")
    private String description;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "capacity_in_bootcamp",
            joinColumns = @JoinColumn(name= "bootcamp_id"),
            inverseJoinColumns = @JoinColumn(name = "capacity_id"))
    private List<CapacityEntity> capacities = new ArrayList<>();
}
