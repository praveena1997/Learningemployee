package com.learning.Employees.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Random;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeesEntity {
    @Id
    @Column(name = "EMPLOYEEID", updatable = false, nullable = false, unique = true)
    private String employeeid;

    @Column(name="FIRSTNAME")
    private String firstname;

    @Column(name="LASTNAME")
    private String lastname;

    @Column(name="PHONENUMBER")
    private String phonenumber;

    @Column(name="EMAIl")
    private String email;

    @Column(name="ADDRESS")
    private String address;

    @PrePersist
    public void generateEmployeeId() {
        this.employeeid = generateCustomId();
    }

    private String generateCustomId() {
        String prefix = "SG24"; // Static prefix
        int randomNum = new Random().nextInt(9000) + 1000;
        return prefix + randomNum;
    }



}
