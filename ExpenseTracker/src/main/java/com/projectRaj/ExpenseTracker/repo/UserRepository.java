package com.projectRaj.ExpenseTracker.repo;

import com.projectRaj.ExpenseTracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}