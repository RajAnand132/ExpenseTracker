package com.projectRaj.ExpenseTracker.service;

import com.projectRaj.ExpenseTracker.models.LoginCheck;
import com.projectRaj.ExpenseTracker.models.User;
import com.projectRaj.ExpenseTracker.repo.LoginRepository;
import com.projectRaj.ExpenseTracker.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginCheckService {
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    UserRepository userRepository;

    public Boolean loggedIn(String userName){
        // Find the user by username
        User user = userRepository.findByUsername(userName);
        Optional<LoginCheck> loggedInUser = loginRepository.findById(user.getId());
        if(loggedInUser.isPresent()){
            return true;
        }
        return false;
    }
}
