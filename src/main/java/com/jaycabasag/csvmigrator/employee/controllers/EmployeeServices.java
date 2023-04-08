package com.jaycabasag.csvmigrator.employee.controllers;

import com.jaycabasag.csvmigrator.employee.Employee;
import com.jaycabasag.csvmigrator.employee.EmployeeRepository;
import com.jaycabasag.csvmigrator.employee.dto.AddEmployeeDataRequest;
import com.jaycabasag.csvmigrator.employee.dto.AddEmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServices {
    private final EmployeeRepository employeeRepository;
    public AddEmployeeResponse addEmployeeData (AddEmployeeDataRequest request) {
        var employeeData = Employee
                .builder()
                .employeeId(request.getEmployeeId())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .hireDate(request.getHireDate())
                .title(request.getTitle())
                .salary(request.getSalary())
                .build();
        employeeRepository.save(employeeData);
        return AddEmployeeResponse
                .builder()
                .message("User added successfully")
                .build();
    }

    public boolean isEmployeeDataExists(AddEmployeeDataRequest request) {
        Long employeeId = request.getEmployeeId();
        Optional<Employee> optionalEmployee = employeeRepository.findUserByEmployeeId(employeeId);
        return optionalEmployee.isPresent();
    }
}
