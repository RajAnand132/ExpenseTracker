package com.projectRaj.ExpenseTracker.controller;

import com.projectRaj.ExpenseTracker.models.Expense;
import com.projectRaj.ExpenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping()
    public String createExpense( @RequestParam String userName, @RequestBody Expense expense) {
        // Handle request to create an expense
        return expenseService.createExpense(expense, userName);
    }

    @GetMapping("/date/{date}")
    public Object getExpensesByDate(@RequestParam String userName, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date ) {
        // Handle request to get expenses by date
        return expenseService.getExpensesByDate(date,userName);
    }

    @PutMapping("/{expenseId}")
    public String updateExpense(@RequestParam String userName, @PathVariable Long expenseId, @RequestBody Expense expense) {
        // Handle request to update an expense by ID
        return expenseService.updateExpense(userName, expenseId, expense);
    }

    @DeleteMapping("/{expenseId}")
    public String deleteExpense(@RequestParam String userName, @PathVariable Long expenseId) {
        // Handle request to delete an expense by ID
        return expenseService.deleteExpense(userName,expenseId);
    }
}

