package com.example.project.Repositories;

import com.example.project.Entity.Leave;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {

    List<Leave> findByLeaveType(String leaveType);

    Page<Leave> findByEmployeeIdAndLeaveTypeOrderById(int employeeId, String leaveType, Pageable pageable);

    List<Leave> findLeavesByFromDateAndToDate(Date fromDate, Date toDate);
//
//    void findByLeaveType_Name(String name);
//
//    void findByEmployeeId(Integer employeeId);

}
