package com.example.bootcamp.adapters.driving.http.dtos.request;

import java.time.LocalDate;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VersionRequest {

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
}
