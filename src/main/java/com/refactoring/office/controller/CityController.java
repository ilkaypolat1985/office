package com.refactoring.office.controller;

import com.refactoring.office.model.Employee;
import com.refactoring.office.model.Office;
import com.refactoring.office.service.EmployeeService;
import com.refactoring.office.service.OfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class CityController {
    private final EmployeeService employeeService;
    private final OfficeService officeService;

    public CityController(final EmployeeService employeeService,
                          final OfficeService officeService) {
        this.employeeService = employeeService;
        this.officeService = officeService;
    }

    @GetMapping("/cities")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getCities() {
        List<String> employeeCities = employeeService.getAll().stream()
                .map(Employee::getCity)
                .collect(Collectors.toList());

        List<String> officeCities = officeService.getAll().stream()
                .map(Office::getCity)
                .collect(Collectors.toList());

        return Stream.concat(employeeCities.stream(), officeCities.stream()).collect(Collectors.toList());
    }
}
