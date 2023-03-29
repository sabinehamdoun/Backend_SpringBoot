package com.example.project.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Table(name="leaveemployee")
@Getter
@Setter
@Entity
public class Leave {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "leave_type")
//    private LeaveType leaveType;

    @Basic@Column(name = "leave_type")
    private String leaveType;

    @Basic@Column(name = "from_date")
    private Date fromDate;

    @Basic@Column(name = "to_date")
    private Date toDate;

    @Basic@Column(name = "number_of_days")
    private Integer numberOfDays;

    @Basic@Column(name = "note")
    private String note;

    @Basic@JoinColumn(name = "employee_id")
    private Integer employeeId;
}
