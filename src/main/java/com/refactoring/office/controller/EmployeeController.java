package com.refactoring.office.controller;

import com.refactoring.office.exception.NotFoundException;
import com.refactoring.office.model.Employee;
import com.refactoring.office.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/employees/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable Integer employeeId) {
        return employeeService.getById(employeeId);
    }

    @ExceptionHandler
    public void handleNotFoundException(NotFoundException exception, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(@Valid @RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @PutMapping("/employees/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployee(@PathVariable Integer employeeId,
                               @RequestBody Employee employee) {
        employeeService.update(employee);
    }
}
