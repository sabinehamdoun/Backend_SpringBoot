package com.example.project.Converters;

import com.example.project.Entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
    DepartmentDTO DepartmentToDepartmentDTO(Department department);
    Department DepartmentDTOToDepartment(DepartmentDTO departmentDto);
}
