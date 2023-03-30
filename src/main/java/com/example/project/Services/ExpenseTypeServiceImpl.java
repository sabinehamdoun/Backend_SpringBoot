package com.example.project.Services;

import com.example.project.Converters.ExpenseTypeDTO;
import com.example.project.Converters.ExpenseTypeMapper;
import com.example.project.Entity.ExpenseType;
import com.example.project.Repositories.ExpenseTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseTypeServiceImpl implements ExpenseTypeService {
    private final ExpenseTypeRepository expenseTypeRepository;
    private final ExpenseTypeMapper expenseTypeMapper;

    public ExpenseTypeServiceImpl(ExpenseTypeRepository expenseTypeRepository, ExpenseTypeMapper expenseTypeMapper) {
        this.expenseTypeRepository = expenseTypeRepository;
        this.expenseTypeMapper = expenseTypeMapper;
    }


    @Override
    public void newExpenseType(ExpenseTypeDTO expenseTypeDTO) {
        ExpenseType expenseTypeToAdd = expenseTypeMapper.ExpenseTypeDTOToExpenseType(expenseTypeDTO);
        expenseTypeRepository.saveAndFlush(expenseTypeToAdd);
    }
}
