package com.example.project.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name="Employee")
@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Basic@Column(name = "name")
    private String name;

    @Basic@Column(name = "email")
    private String email;

    @Basic@Column(name = "address")
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

//    @OneToMany(mappedBy = "leaveemployee", cascade = CascadeType.ALL)
//    private List<Leave> leaves;

}
