package com.example.project.Services;

import com.example.project.Converters.ExpenseClaimEntryDTO;
import com.example.project.Converters.ExpenseClaimEntryMapper;
import com.example.project.Entity.ExpenseClaimEntry;
import com.example.project.Repositories.ExpenseClaimEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseClaimEntryImpl implements ExpenseClaimEntryService{

    private final ExpenseClaimEntryRepository expenseClaimEntryRepository;
    private final ExpenseClaimEntryMapper expenseClaimEntryMapper;

    public ExpenseClaimEntryImpl(ExpenseClaimEntryRepository expenseClaimEntryRepository, ExpenseClaimEntryMapper expenseClaimEntryMapper) {
        this.expenseClaimEntryRepository = expenseClaimEntryRepository;
        this.expenseClaimEntryMapper = expenseClaimEntryMapper;
    }

    @Override
    public List<ExpenseClaimEntryDTO> getAll() {
        List<ExpenseClaimEntryDTO> expenseClaim = expenseClaimEntryRepository.findAll().stream().map( expense -> {
            ExpenseClaimEntryDTO expenseClaimEntryDTO = expenseClaimEntryMapper.ExpenseClaimEntryToExpenseClaimEntryMapperDTO(expense);
            return expenseClaimEntryDTO;
        }).collect(Collectors.toList());

        return expenseClaim;
    }

    @Override
    public ExpenseClaimEntry findById(int id) {
        ExpenseClaimEntry expenseClaimEntry = expenseClaimEntryRepository.findById(id).get();
        ExpenseClaimEntryDTO expenseClaimEntryDTO  = expenseClaimEntryMapper.ExpenseClaimEntryToExpenseClaimEntryMapperDTO(expenseClaimEntry);
        return expenseClaimEntry;
    }

    @Override
    public void submitNewExpense(ExpenseClaimEntryDTO expenseClaimEntryDTO){
        ExpenseClaimEntry expenseToAdd = expenseClaimEntryMapper.ExpenseClaimEntryDTOToExpenseClaimEntryMapper(expenseClaimEntryDTO);
        expenseClaimEntryRepository.saveAndFlush(expenseToAdd);
    }

    public int total() {
        return expenseClaimEntryRepository.total();
    }

}
