package com.example.ems.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
