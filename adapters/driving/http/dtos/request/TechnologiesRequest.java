package com.example.bootcamp.adapters.driving.http.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
public  class TechnologiesRequest {

    
    @NotNull(message = "The name cannot be empty")
    @Size(min = 2, max = 50, message = "The name must be between 2 and 50 characters")
    private String name;
    
    @NotNull(message = "The description cannot be empty")
    @Size(min = 5, max = 90, message = "The description must be between 5 and 90 characters")
    private String description;
    
    
}


