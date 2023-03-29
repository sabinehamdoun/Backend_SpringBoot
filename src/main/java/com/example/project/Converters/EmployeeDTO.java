package com.example.project.Converters;

import com.example.project.Entity.Department;
import com.example.project.Entity.Leave;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {

    private Integer id;

    private String name;

    private String email;

    private String address;

    private Department department;

    private List<Leave> leaves;

}
