package com.example.project.Services;

import com.example.project.Converters.LeaveDTO;
import com.example.project.Entity.Leave;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface LeaveService {
    List<LeaveDTO> getAll();

    void submitLeave(LeaveDTO leaveDTO);

    Page<Leave> getLeavesByEmployeeAndLeaveType(int employeeId, String leaveType, Pageable pageable);

    List<Leave> getLeavesByLeaveType(String leaveType);

    List<Leave> getLeavesByRangeDate(Date fromDate, Date toDate);


}
