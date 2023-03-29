package com.example.project.Controller;

import com.example.project.Converters.EmployeeDTO;
import com.example.project.Entity.Employee;
import com.example.project.Services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/getAllEmployees", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTO findById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @GetMapping(value = "/department/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployeeByDepartment(@PathVariable int departmentId) {
        return employeeService.getEmployeeByDepartment(departmentId);
    }

    @PostMapping(value = "/addNewEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> addNewEmployee(@RequestBody EmployeeDTO employeeDto) {
        employeeService.newEmployee(employeeDto);
        HashMap<String, Object> map = new HashMap<>();
        map.put("Success", true);
        map.put("message", "Employee created successfully");
        return map;
    }

    @PutMapping(value = "/updateEmployee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDto) {
        employeeService.updateEmployee(id, employeeDto);
        HashMap<String, Object> map = new HashMap<>();
        map.put("Success", true);
        map.put("message", "Employee updated");
        return map;
    }


}

