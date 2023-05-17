package com.example.Spring.BootCrud.Operations.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "emp")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "email")
    private String email;

}
