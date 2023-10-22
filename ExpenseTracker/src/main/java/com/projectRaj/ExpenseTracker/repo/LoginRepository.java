package com.projectRaj.ExpenseTracker.repo;

import com.projectRaj.ExpenseTracker.models.LoginCheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginCheck,Long> {
}
