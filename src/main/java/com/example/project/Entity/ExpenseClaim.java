package com.example.project.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Table(name="expenseClaim")
@Getter
@Setter
@Entity
public class ExpenseClaim {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic@Column(name = "description")
    private String description;

    @Basic@Column(name = "total")
    private Integer total;

    @Basic@JoinColumn(name = "status")
    private String status;

    @OneToMany(mappedBy = "expenseClaim", cascade = CascadeType.ALL)
    private List<ExpenseClaimEntry> expenseClaim;
}
