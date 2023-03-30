package com.example.project.Controller;

import com.example.project.Converters.LeaveTypeDTO;
import com.example.project.Services.LeaveTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "leaveType")
@CrossOrigin(origins = "*")
public class LeaveTypeController {

    private final LeaveTypeService leaveTypeService;

    public LeaveTypeController(LeaveTypeService leaveTypeService) {
        this.leaveTypeService = leaveTypeService;
    }

    @PostMapping(value = "/addNewLeaveType", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> addNewLeaveType(@RequestBody LeaveTypeDTO leaveTypeDTO) {
        leaveTypeService.newLeaveType(leaveTypeDTO);
        HashMap<String, Object> map = new HashMap<>();
        map.put("Success", true);
        map.put("message", "Leave Type added successfully");
        return map;
    }
}