package com.projectRaj.ExpenseTracker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LoginCheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginId;
    @Column(nullable = false)
    private Boolean loggedIn;
    @OneToOne
    @JoinColumn(name = "fk_user_id")
    private User user;
}
