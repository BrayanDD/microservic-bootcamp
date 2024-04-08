package com.example.bootcamp.adapters.driving.http.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDate;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootcamp.adapters.driving.http.dtos.request.BootcampRequest;
import com.example.bootcamp.adapters.driving.http.dtos.request.CapacityRequest;
import com.example.bootcamp.adapters.driving.http.dtos.request.TechnologiesRequest;
import com.example.bootcamp.adapters.driving.http.dtos.request.VersionRequest;
import com.example.bootcamp.adapters.driving.http.dtos.response.BootcampResponse;
import com.example.bootcamp.adapters.driving.http.dtos.response.CapacityResponse;
import com.example.bootcamp.adapters.driving.http.dtos.response.TechnologiesResponse;
import com.example.bootcamp.adapters.driving.http.dtos.response.VersionResponse;
import com.example.bootcamp.adapters.driving.http.mapper.IBootcampRequestMapper;
import com.example.bootcamp.adapters.driving.http.mapper.IBootcampResponseMapper;
import com.example.bootcamp.adapters.driving.http.mapper.ICapacityRequestMapper;
import com.example.bootcamp.adapters.driving.http.mapper.ICapacityResponseMapper;
import com.example.bootcamp.adapters.driving.http.mapper.ITechnologiesRequestMapper;
import com.example.bootcamp.adapters.driving.http.mapper.ITechnologiesResponseMapper;
import com.example.bootcamp.adapters.driving.http.mapper.IVersionRequestMapper;
import com.example.bootcamp.adapters.driving.http.mapper.IVersionResponseMapper;
import com.example.bootcamp.domain.api.IBootcampServicePort;
import com.example.bootcamp.domain.api.ICapacityServicePort;
import com.example.bootcamp.domain.api.ITechnologyServicePort;
import com.example.bootcamp.domain.api.IVersionServicePort;
import com.example.bootcamp.domain.model.Bootcamp;
import com.example.bootcamp.domain.model.Capacity;
import com.example.bootcamp.domain.model.Technology;
import com.example.bootcamp.domain.model.Version;


import javax.validation.Valid;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/onclass")
@RequiredArgsConstructor
public class TechnologiesRestController {
    private final ITechnologyServicePort technologyServicePort;
    private final ITechnologiesRequestMapper technologiesRequestMapper;
    private final ITechnologiesResponseMapper technologiesResponseMapper;

    private final ICapacityServicePort capacityServicePort;
    private final ICapacityRequestMapper capacityRequestMapper;
    private final ICapacityResponseMapper capacityResponseMapper;
    

    private final IBootcampServicePort bootcampServicePort;
    private final IBootcampRequestMapper bootcampRequestMapper;
    private final IBootcampResponseMapper bootcampResponseMapper;

    private final IVersionServicePort versionServicePort;
    private final IVersionRequestMapper versionRequestMapper;
    private final IVersionResponseMapper versionResponseMapper;

    @PostMapping("/technologies")
    public ResponseEntity<String> saveTechnology(@Valid @RequestBody TechnologiesRequest technologiesRequest){
        Long createdTechnologyId = technologyServicePort.saveTechnology(technologiesRequestMapper.toTechnology(technologiesRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body("Id technology is: " + createdTechnologyId);
    }


    @GetMapping("/technologies")
    public ResponseEntity<List<TechnologiesResponse>> getAllTechnologyInTechnologies(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "asc") String order) {
            
        Sort.Direction direction = Sort.Direction.ASC;
        if (order.equalsIgnoreCase("desc")) {
            direction = Sort.Direction.DESC;
        }
    
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, "name"));
        Page<Technology> technologyPage = technologyServicePort.getAllTechnology(pageable);
        return ResponseEntity.ok(technologiesResponseMapper.toResponseList(technologyPage));
    }

    //////////////////////////////////////////

    @PostMapping("/capabilities")
    public ResponseEntity<String> saveCapacity(@Valid @RequestBody CapacityRequest capacityRequest){
        Long createdCapacityId = capacityServicePort.saveCapacity(capacityRequestMapper.toCapacity(capacityRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body("Id capacity is: " + createdCapacityId);

    }

    @GetMapping("/capabilities")
    public ResponseEntity<List<CapacityResponse>> getAllCapacityInCapabilities(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) Integer technologiesCount,
        @RequestParam(defaultValue = "asc") String order) {
        
        Sort.Direction direction = Sort.Direction.ASC;
        if (order.equalsIgnoreCase("desc")) {
            direction = Sort.Direction.DESC;
        }
        
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction,"name"));
        Page<Capacity> capacityPage = capacityServicePort.getAllCapacity(pageable, technologiesCount);
        return ResponseEntity.ok(capacityResponseMapper.toResponseList(capacityPage));
    }

    
    //////////////////////////////

    @PostMapping("/bootcamps")
    public ResponseEntity<String> saveCapacity(@Valid @RequestBody BootcampRequest bootcampRequest){
        Long createdBootcampId = bootcampServicePort.saveBootcamp(bootcampRequestMapper.toBootcamp(bootcampRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body("Id capacity is: " + createdBootcampId);

    }

    @GetMapping("/bootcamps")
    public ResponseEntity<List<BootcampResponse>> getAllBootcampInBootcamps(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) Integer capacitiesCount,
        @RequestParam(defaultValue = "asc") String order) {
        
        Sort.Direction direction = Sort.Direction.ASC;
        if (order.equalsIgnoreCase("desc")) {
            direction = Sort.Direction.DESC;
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction,"name"));
        Page<Bootcamp> bootcampPage = bootcampServicePort.getAllBootcamp(pageable, capacitiesCount);
        return ResponseEntity.ok(bootcampResponseMapper.toResponseList(bootcampPage));
    }

    //////////////////
    @PostMapping("/version")
    public ResponseEntity<String> saveVersion(@Valid @RequestBody VersionRequest versionRequest){
        Long createVersion = versionServicePort.saveVersion(versionRequestMapper.toVersion(versionRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body("Id version is: " + createVersion);
    }

    @GetMapping("/version")
    public ResponseEntity<List<VersionResponse>> getAllVersion(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) Long maxCoup,
        @RequestParam(required = false) String fechStar, 
        @RequestParam(required = false) Long idBootcamp,
        @RequestParam(defaultValue = "asc") String order) {
        
        LocalDate startDate = null;
        if (fechStar != null) {
       
            startDate = LocalDate.parse(fechStar);
        }

        Sort.Direction direction = Sort.Direction.ASC;
        if (order.equalsIgnoreCase("desc")) {
            direction = Sort.Direction.DESC;
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction,"bootcamp.name"));
        Page<Version> versionPage = versionServicePort.getAllVersions(pageable,maxCoup,startDate,idBootcamp);

        return ResponseEntity.ok(versionResponseMapper.toResponseList(versionPage));
    }

}
