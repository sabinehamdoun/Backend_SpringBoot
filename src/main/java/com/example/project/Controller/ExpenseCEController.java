package com.example.project.Controller;

import com.example.project.Converters.ExpenseClaimEntryDTO;
import com.example.project.Entity.ExpenseClaimEntry;
import com.example.project.Services.ExpenseClaimEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "expenseClaimEntry")
@CrossOrigin(origins = "*")
public class ExpenseCEController {

    private final ExpenseClaimEntryService expenseClaimEntryService;

    public ExpenseCEController(ExpenseClaimEntryService expenseClaimEntryService) {
        this.expenseClaimEntryService = expenseClaimEntryService;
    }

    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ExpenseClaimEntryDTO> getAllExpenses() {
        return expenseClaimEntryService.getAll();
    }

    @GetMapping(value = "/getById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ExpenseClaimEntry findById(@PathVariable int id) {
        return expenseClaimEntryService.findById(id);
    }

    @PostMapping(value = "/addNewUser", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> submitNewExpense(@RequestBody ExpenseClaimEntryDTO expenseClaimEntryDTO) {
        expenseClaimEntryService.submitNewExpense(expenseClaimEntryDTO);
        HashMap<String, Object> map = new HashMap<>();
        map.put("Success", true);
        map.put("message", "Employee created successfully");
        return map;
    }
}
