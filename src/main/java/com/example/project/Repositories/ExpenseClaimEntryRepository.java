package com.example.project.Repositories;

import com.example.project.Entity.ExpenseClaimEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExpenseClaimEntryRepository extends JpaRepository<ExpenseClaimEntry, Integer> {
    @Query(value = "SELECT sum(total) FROM ExpenseClaim ")
    public int total();
}
