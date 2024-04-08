package com.example.bootcamp.domain.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Bootcamp {
    private Long id;
    private String name;
    private String description;
    private List<Capacity> capacities;
    private List<Long> capacitiesIds;

    public Bootcamp() {
        this.capacities = new ArrayList<>();
        this.capacitiesIds = new ArrayList<>();
    }

    public Bootcamp(Long id, String name, String description, List<Capacity> capacities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacities = capacities;
        this.capacitiesIds = new ArrayList<>();
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

    public List<Capacity> getCapacities() {
        return capacities;
    }

    public void setCapacities(List<Capacity> capacities) {
        this.capacities = capacities;
    }

    public List<Long> getCapacitiesIds() {
        return capacitiesIds;
    }

    public void setCapacitiesIds(List<Long> capacitiesIds) {
        this.capacitiesIds = capacitiesIds;
    } 

    public boolean isValid() {
       
            return !capacitiesIds.isEmpty() && capacitiesIds.size() <= 4;
        

    }

    public boolean areIdsUnique() {
                
        Set<Long> uniqueIds = new HashSet<>(capacitiesIds);
        return uniqueIds.size() == capacitiesIds.size();
    }

    
}
