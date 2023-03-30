package com.example.project.Services;


import com.example.project.Converters.DepartmentDTO;
import com.example.project.Converters.DepartmentMapper;
import com.example.project.Entity.Department;
import com.example.project.Entity.Employee;
import com.example.project.Repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public void newDepartment(DepartmentDTO departmentDTO) {
        Department departmentToAdd = departmentMapper.DepartmentDTOToDepartment(departmentDTO);
        departmentRepository.saveAndFlush(departmentToAdd);
    }
}
