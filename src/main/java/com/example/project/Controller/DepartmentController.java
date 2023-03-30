package com.example.project.Controller;

import com.example.project.Converters.DepartmentDTO;
import com.example.project.Services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "department")
@CrossOrigin(origins = "*")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @PostMapping(value = "/addNewDepartment", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> addNewEmployee(@RequestBody DepartmentDTO departmentDTO) {
        departmentService.newDepartment(departmentDTO);
        HashMap<String, Object> map = new HashMap<>();
        map.put("Success", true);
        map.put("message", "Department created successfully");
        return map;
    }
}
