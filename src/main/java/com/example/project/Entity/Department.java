package com.example.project.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "department")
@Getter
@Setter
@Entity
public class Department {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Basic@Column(name="name")
    private String name;

//    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
//    private List<Employee> employee;
}
