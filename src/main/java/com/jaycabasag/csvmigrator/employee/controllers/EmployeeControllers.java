package com.jaycabasag.csvmigrator.employee.controllers;

import com.jaycabasag.csvmigrator.employee.dto.AddEmployeeDataRequest;
import com.jaycabasag.csvmigrator.employee.dto.AddEmployeeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeControllers {
    private final EmployeeServices employeeServices;
    public EmployeeControllers(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @PostMapping()
    public ResponseEntity<AddEmployeeResponse> addEmployeeData(
            @RequestBody AddEmployeeDataRequest request
    ){
        if (employeeServices.isEmployeeDataExists(request)){
            AddEmployeeResponse duplicateResponse = new AddEmployeeResponse("Already reported.");
            return new ResponseEntity<>(duplicateResponse, HttpStatus.ALREADY_REPORTED);
        }
        AddEmployeeResponse response = employeeServices.addEmployeeData(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
