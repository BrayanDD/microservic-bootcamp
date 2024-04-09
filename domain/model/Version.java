package com.example.bootcamp.domain.model;

import java.time.LocalDate;

public class Version {
    private Long id;
    private String versionName;
    private Long idBootcamp;
    private String bootcampName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long maxCapacity; 

    public Version(Long id, String versionName, Long idBootcamp, LocalDate startDate, LocalDate endDate, Long maxCapacity) {
        this.id = id;
        this.versionName = versionName;
        this.idBootcamp = idBootcamp;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxCapacity = maxCapacity; 
    }

    
  
    public Version() {
    }



    public boolean isValid() {
        
       
         
        return endDate.isAfter(startDate);
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdBootcamp() {
        return idBootcamp;
    }

    public void setIdBootcamp(Long idBootcamp) {
        this.idBootcamp = idBootcamp;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }



    public String getVersion() {
        return versionName;
    }



    public void setVersion(String versionName) {
        this.versionName = versionName;
    }



    public Long getMaxCapacity() {
        return maxCapacity;
    }



    public void setMaxCapacity(Long maxCapacity) {
        this.maxCapacity = maxCapacity;
    }



    public String getBootcampName() {
        return bootcampName;
    }



    public void setBootcampName(String bootcampName) {
        this.bootcampName = bootcampName;
    }

    
    
}
