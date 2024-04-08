package com.example.bootcamp.domain.model;

import java.util.ArrayList;

import java.util.List;

import java.util.HashSet;

import java.util.Set;

public class Capacity {

    private Long id;
    private String name;
    private String description;
    private List<Technology> technologies;
    private List<Long> technologyIds; 

    public Capacity() {
        this.technologies = new ArrayList<>();
        this.technologyIds = new ArrayList<>();
    }

    public Capacity(Long id, String name, String description, List<Technology> technologies) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.technologies = technologies;
        this.technologyIds = new ArrayList<>();
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;

    }

    public List<Long> getTechnologyIds() {
        return technologyIds;
    }

    public void setTechnologyIds(List<Long> technologyIds) {
        this.technologyIds = technologyIds;
    }

    public boolean isValid() {
        return technologyIds.size() >= 3 && technologyIds.size() <= 20 && areIdsUnique();
    }
    
    public boolean areIdsUnique() {
        Set<Long> uniqueIds = new HashSet<>(technologyIds);
        return uniqueIds.size() == technologyIds.size();
    }
    
    
}
