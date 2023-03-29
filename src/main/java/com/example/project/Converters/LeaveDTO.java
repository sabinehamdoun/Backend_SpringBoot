package com.example.project.Converters;

import com.example.project.Entity.Leave;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.Data;

import java.util.Date;

@Data
public class LeaveDTO {
    private Integer id;

//    private Leave leaveType;
    private String leaveType;

    private Date fromDate;

    private Date toDate;

    private Integer numberOfDays;

    private String note;

    private Integer employeeId;

}
