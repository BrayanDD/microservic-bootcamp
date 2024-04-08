package com.example.bootcamp.adapters.driving.http.dtos.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CapacityResponse {
    private Long id;
    private String name;
    private String description;
    private List<TechnologyInCapabilities> technologies;

}
