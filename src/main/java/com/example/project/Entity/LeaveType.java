package com.example.project.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name="leavetype")
@Getter
@Setter
@Entity
public class LeaveType {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Basic@Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "leaveType", cascade = CascadeType.ALL)
//    private List<Leave> leaves;
}
