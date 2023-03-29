package com.example.project.Services;

 import com.example.project.Converters.EmployeeDTO;
import com.example.project.Converters.EmployeeMapper;
import com.example.project.Entity.Employee;
import com.example.project.Repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        List<EmployeeDTO> employees = employeeRepository.findAll().stream().map( employee -> {
            EmployeeDTO employeeDto = employeeMapper.EmployeeToEmployeeDTO(employee);
            return employeeDto;
        }).collect(Collectors.toList());

        return employees;
    }

    @Override
    public EmployeeDTO findById(int id) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeDTO employeeDTO = employeeMapper.EmployeeToEmployeeDTO(employee);
        return employeeDTO;
    }

    @Override
    public void newEmployee(EmployeeDTO newEmployee) {
        Employee employeeToAdd = employeeMapper.EmployeeDTOToEmployee(newEmployee);
        employeeRepository.saveAndFlush(employeeToAdd);
    }

    @Override
    public void updateEmployee(int id, EmployeeDTO employeeDto) {
        Employee updateUser = employeeRepository.findById(id).get();
        updateUser.setName(employeeDto.getName());
        updateUser.setEmail(employeeDto.getEmail());
        updateUser.setAddress(employeeDto.getAddress());
//        updateUser.setDepartmentId(employeeDto.getDepartment_id());
        employeeRepository.saveAndFlush(updateUser);

    }

    public List<Employee> getEmployeeByDepartment(int departmentId) {
        List<Employee> employeeList = employeeRepository.findByDepartmentId(departmentId);
        return employeeList;
    }
}

