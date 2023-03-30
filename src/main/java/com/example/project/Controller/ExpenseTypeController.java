package com.example.project.Controller;

import com.example.project.Converters.ExpenseTypeDTO;
import com.example.project.Services.ExpenseTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "leaveType")
@CrossOrigin(origins = "*")
public class ExpenseTypeController {
    private final ExpenseTypeService expenseTypeService;

    public ExpenseTypeController(ExpenseTypeService expenseTypeService) {
        this.expenseTypeService = expenseTypeService;
    }

    @PostMapping(value = "/addNewExpenseType", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> addNewExpenseType(@RequestBody ExpenseTypeDTO expenseTypeDTO) {
        expenseTypeService.newExpenseType(expenseTypeDTO);
        HashMap<String, Object> map = new HashMap<>();
        map.put("Success", true);
        map.put("message", "Expense Type Added successfully");
        return map;
    }
}
