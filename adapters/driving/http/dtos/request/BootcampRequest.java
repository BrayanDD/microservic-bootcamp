package com.example.bootcamp.adapters.driving.http.dtos.request;


import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BootcampRequest {

    @NotEmpty(message = "The bootcamp name cannot be empty")
    @Size(min = 5, max = 50, message = "The maximum name length is 50 characters")
    private String name;
    
    @NotEmpty(message = "The bootcamp description cannot be empty")
    @Size(min = 5, max = 90, message = "The maximum description length is 90 characters")
    private String description;
    
    @NotEmpty(message = "The list of capacities cannot be empty")
    private List<Long> capacitiesIds;
}
