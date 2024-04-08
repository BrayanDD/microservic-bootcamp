package com.example.bootcamp.adapters.driven.jpa.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "capacity_in_bootcamp")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CapacityInBootcamp {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "capacity_id")
    private CapacityEntity capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bootcamp_id")
    private BootcampEntity bootcampEntity;

    public void setName(String name) {

        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }
}
