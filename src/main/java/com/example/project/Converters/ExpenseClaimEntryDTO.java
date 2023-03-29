package com.example.project.Converters;

import com.example.project.Entity.ExpenseClaim;
import lombok.Data;

import java.util.Date;

@Data
public class ExpenseClaimEntryDTO {
    private Integer id;

    private Date date;

    private String description;

    private Integer total;

    private String expenseType;

    private ExpenseClaim expenseClaim;


}
