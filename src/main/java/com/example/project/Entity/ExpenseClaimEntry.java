package com.example.project.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Table(name="expenseclaimentry")
@Getter
@Setter
@Entity
public class ExpenseClaimEntry {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Basic@Column(name = "date")
    private Date date;

    @Basic@Column(name = "expense_type")
    private String expenseType;

    @Basic@Column(name = "description")
    private String description;

    @Basic@Column(name = "total")
    private Integer total;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_expense_claim")
    private ExpenseClaim expenseClaim;
}

