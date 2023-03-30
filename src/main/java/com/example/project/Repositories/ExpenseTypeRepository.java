package com.example.project.Repositories;

import com.example.project.Entity.ExpenseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseTypeRepository extends JpaRepository<ExpenseType, Integer> {
}
