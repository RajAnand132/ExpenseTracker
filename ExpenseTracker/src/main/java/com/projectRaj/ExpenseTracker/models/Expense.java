package com.projectRaj.ExpenseTracker.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "expenses")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope=Expense.class,property="expenseId")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private LocalDate date;

    @Column
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

}

