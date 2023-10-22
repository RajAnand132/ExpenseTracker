package com.projectRaj.ExpenseTracker.repo;

import com.projectRaj.ExpenseTracker.models.Expense;
import com.projectRaj.ExpenseTracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByDateAndUser(LocalDate date, User user);
}