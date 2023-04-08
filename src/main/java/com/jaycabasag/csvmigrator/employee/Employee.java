package com.jaycabasag.csvmigrator.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private Long employeeId;
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Title title;
    private LocalDate hireDate;
    private Double salary;
}
