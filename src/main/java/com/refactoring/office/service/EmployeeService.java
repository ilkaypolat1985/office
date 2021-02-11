package com.refactoring.office.service;

import com.refactoring.office.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(Integer id);
    void save(Employee employee);
    void update(Employee employee);
}
