package com.projectRaj.ExpenseTracker.models.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Component
public class ExpenseResponse {

    private Long expenseId;

    private String title;

    private String description;

    private double price;

    private LocalDate date;

    private LocalTime time;
}
