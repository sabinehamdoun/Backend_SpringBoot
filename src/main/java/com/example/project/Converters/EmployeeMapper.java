package com.example.project.Converters;

import com.example.project.Entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    EmployeeDTO EmployeeToEmployeeDTO(Employee employee);
    Employee EmployeeDTOToEmployee(EmployeeDTO employeeDto);
}

