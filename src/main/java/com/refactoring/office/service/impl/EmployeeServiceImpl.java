package com.refactoring.office.service.impl;

import com.refactoring.office.exception.NotFoundException;
import com.refactoring.office.model.Employee;
import com.refactoring.office.model.mapper.EmployeeMapper;
import com.refactoring.office.repository.EmployeeRepository;
import com.refactoring.office.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper.INSTANCE::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Employee getById(Integer id) {
        return employeeRepository.findById(id)
                .map(EmployeeMapper.INSTANCE::toModel)
                .orElseThrow(() -> new NotFoundException("Employee not found! " + id));
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(EmployeeMapper.INSTANCE.toEntity(employee));
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(EmployeeMapper.INSTANCE.toEntity(employee));
    }
}
