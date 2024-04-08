package com.example.bootcamp.adapters.driving.http.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CapacityInBootcamp {
    private Long id;
    private String name;
    private List<TechnologyInCapabilities> technologies;

}
