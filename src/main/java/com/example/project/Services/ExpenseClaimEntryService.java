package com.example.project.Services;

import com.example.project.Converters.ExpenseClaimEntryDTO;
import com.example.project.Entity.ExpenseClaimEntry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpenseClaimEntryService {
    List<ExpenseClaimEntryDTO> getAll();
    ExpenseClaimEntry findById(int id);
//    List<Employee> getEmployeeByDepartment(int departmentId);

    void submitNewExpense(ExpenseClaimEntryDTO expenseClaimEntryDTO);
//    void updateEmployee(int id, EmployeeDTO employeeDto);

}