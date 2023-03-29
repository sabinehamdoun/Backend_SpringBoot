package com.example.project.Controller;


import com.example.project.Converters.LeaveDTO;
import com.example.project.Entity.Leave;
import com.example.project.Services.LeaveService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

 import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "leaveemployee")
@CrossOrigin(origins = "*")
public class LeaveController {
    private final LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @GetMapping(value = "/getAllLeaves", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<LeaveDTO> getAllLeaves() {
        return leaveService.getAll();
    }

    @PostMapping(value = "/submitLeave", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> submitEmployeeLeave(@RequestBody LeaveDTO leaveDTO) {
        leaveService.submitLeave(leaveDTO);
        HashMap<String, Object> map = new HashMap<>();
        map.put("Success", true);
        map.put("message", "Leave submitted successfully");
        return map;
    }


    @GetMapping(value = "/leaves", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Page<Leave> getLeavesByEmployeeAndLeaveType(@RequestParam int employeeId, @RequestParam String leaveType,
                                                       @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return leaveService.getLeavesByEmployeeAndLeaveType(employeeId, leaveType, pageable);
    }

    @GetMapping(value = "/leaves/{fromDate}/{toDate}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Leave> getLeavesByRangeDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {
        return leaveService.getLeavesByRangeDate(fromDate, toDate);
    }

    @GetMapping(value = "/leaves/LeaveType/{leaveType}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Leave> getLeavesByLeaveType(@PathVariable("leaveType") String leaveType) {
        return leaveService.getLeavesByLeaveType(leaveType);
    }
}
