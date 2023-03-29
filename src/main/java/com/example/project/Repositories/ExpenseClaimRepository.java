package com.example.project.Repositories;

import com.example.project.Entity.ExpenseClaim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseClaimRepository extends JpaRepository<ExpenseClaim, Integer> {
//    List<ExpenseClaim> findByEmployeeId(Integer employeeId);
}
