package com.anmol.UserService.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends User {
    String role = "ROLE_EMPLOYEE";
}
