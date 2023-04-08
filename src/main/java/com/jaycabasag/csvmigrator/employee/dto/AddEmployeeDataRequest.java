package com.jaycabasag.csvmigrator.employee.dto;

import com.jaycabasag.csvmigrator.employee.Title;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeDataRequest {
    private Long employeeId;
    private String firstname;
    private String lastname;
    private Title title;
    private LocalDate hireDate;
    private Double salary;
}
