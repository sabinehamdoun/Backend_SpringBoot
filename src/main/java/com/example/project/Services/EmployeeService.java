package com.example.project.Services;

import com.example.project.Converters.EmployeeDTO;
import com.example.project.Entity.Employee;

import java.util.List;


public interface EmployeeService {
    List<EmployeeDTO> getAll();
    EmployeeDTO findById(int id);
    List<Employee> getEmployeeByDepartment(int departmentId);

    void newEmployee(EmployeeDTO employeeDto);
    void updateEmployee(int id, EmployeeDTO employeeDto);


}
