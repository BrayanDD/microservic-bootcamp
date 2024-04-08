package com.example.bootcamp.adapters.driving.http.dtos.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VersionResponse {

    private Long id;
    private String version;
    private Long idBootcamp;
    private String bootcampName; 
    private LocalDate startDate;
    private LocalDate endDate;
    private Long maxCapacity; 
}
