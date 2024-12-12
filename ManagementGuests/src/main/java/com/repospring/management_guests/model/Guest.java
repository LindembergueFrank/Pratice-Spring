package com.repospring.management_guests.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Guest implements Serializable {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer numberCompanion;

}
