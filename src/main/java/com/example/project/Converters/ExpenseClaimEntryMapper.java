package com.example.project.Converters;

import com.example.project.Entity.ExpenseClaimEntry;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseClaimEntryMapper {
    ExpenseClaimEntryMapper INSTANCE = Mappers.getMapper(ExpenseClaimEntryMapper.class);
    ExpenseClaimEntryDTO ExpenseClaimEntryToExpenseClaimEntryMapperDTO(ExpenseClaimEntry expenseClaimEntry);
    ExpenseClaimEntry ExpenseClaimEntryDTOToExpenseClaimEntryMapper(ExpenseClaimEntryDTO expenseClaimEntryDTO);

}
