package com.projectRaj.ExpenseTracker.service;

import com.projectRaj.ExpenseTracker.models.Expense;
import com.projectRaj.ExpenseTracker.models.User;
import com.projectRaj.ExpenseTracker.repo.ExpenseRepository;
import com.projectRaj.ExpenseTracker.repo.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    LoginCheckService loginCheckService;

    @Autowired
    UserRepository userRepository;

    public String createExpense(Expense expense, String userName) {
        User user = userRepository.findByUsername(userName);

        if (user == null) {
            return "Invalid user !!!";
        }

        if (loginCheckService.loggedIn(userName)) {
            // Associate the expense with the user
            expense.setUser(user);

            // Save the expense
            expenseRepository.save(expense);

            return "Expense has been added into the repository";
        }

        return "You are not logged in. Please log in first !!!";
    }


    public Object getExpensesByDate(LocalDate date, String userName) {
        User user = userRepository.findByUsername(userName);

        if (user == null) {
            return "Invalid user !!!";
        }

        if (loginCheckService.loggedIn(userName)) {
            List<Expense> expenses = expenseRepository.findByDateAndUser(date, user);

            if (expenses.isEmpty()) {
                return "No expenses found for the given date.";
            }

            return expenses;
        }

        return "You are not logged in. Please log in first !!!";
    }



    public String updateExpense(String userName, Long id, Expense updatedExpense) {
        User user = userRepository.findByUsername(userName);

        if (user == null) {
            return "Invalid user !!!";
        }

        if (loginCheckService.loggedIn(userName)) {
            // Find the expense by ID
            Optional<Expense> existingExpenseOptional = expenseRepository.findById(id);

            if (existingExpenseOptional.isPresent()) {
                Expense existingExpense = existingExpenseOptional.get();

                // Ensure that the user is the owner of the expense
                if (!existingExpense.getUser().getId().equals(user.getId())) {
                    return "Expense with ID " + id + " does not belong to the user: "+ userName;
                }

                // Update the fields
                existingExpense.setTitle(updatedExpense.getTitle());
                existingExpense.setDescription(updatedExpense.getDescription());
                existingExpense.setPrice(updatedExpense.getPrice());
                existingExpense.setDate(updatedExpense.getDate());
                existingExpense.setTime(updatedExpense.getTime());

                // Save the updated expense
                expenseRepository.save(existingExpense);
                return "Expense with ID " + id + " is updated";
            } else {
                return "Expense with ID " + id + " not found";
            }
        }

        return "You are not logged in. Please log in first !!!";
    }

    public String deleteExpense(String userName, Long id) {
        User user = userRepository.findByUsername(userName);

        if (user == null) {
            return "Invalid user !!!";
        }
        if (loginCheckService.loggedIn(userName)) {
            // Find the expense by ID
            Optional<Expense> existingExpense = expenseRepository.findById(id);

            if (existingExpense.isPresent()) {
                Expense expense = existingExpense.get();

                // Ensure that the user is the owner of the expense
                if (expense.getUser().getId().equals(user.getId())) {
                    // Delete the expense
                    expenseRepository.delete(expense);
                    return "Expense with ID: " + id + " is deleted";
                } else {
                    return "Expense with ID " + id + " does not belong to the user: "+ userName;
                }
            }

            return "Expense with ID " + id + " not found";
        }

        return "You are not logged in. Please login first !!!";
    }
}
