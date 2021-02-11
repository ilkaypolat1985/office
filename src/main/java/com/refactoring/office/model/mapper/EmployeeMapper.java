package com.refactoring.office.model.mapper;

import com.refactoring.office.entity.EmployeeEntity;
import com.refactoring.office.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper( EmployeeMapper.class );

    Employee toModel(EmployeeEntity employeeEntity);
    EmployeeEntity toEntity(Employee employee);
}
