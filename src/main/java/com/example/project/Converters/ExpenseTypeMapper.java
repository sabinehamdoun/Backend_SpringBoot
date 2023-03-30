package com.example.project.Converters;

import com.example.project.Entity.Department;
import com.example.project.Entity.ExpenseType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseTypeMapper {
    ExpenseTypeMapper INSTANCE = Mappers.getMapper(ExpenseTypeMapper.class);
    ExpenseTypeDTO ExpenseTypeToExpenseTypeDTO(ExpenseType expenseType);
    ExpenseType ExpenseTypeDTOToExpenseType(ExpenseTypeDTO expenseTypeDTO);
}
