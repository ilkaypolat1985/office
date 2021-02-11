package com.refactoring.office.controller;

import com.refactoring.office.model.Employee;
import com.refactoring.office.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CountryController {
    private final EmployeeService employeeService;

    public CountryController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/countries")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getCountries() {
        return employeeService.getAll().stream()
                .map(Employee::getCountry)
                .collect(Collectors.toList());
    }
}
