package com.example.project.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "expenseType")
@Getter
@Setter
@Entity
public class ExpenseType {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Basic
    @Column(name="name")
    private String name;

}
