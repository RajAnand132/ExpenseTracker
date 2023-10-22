package com.projectRaj.ExpenseTracker.service;

import com.projectRaj.ExpenseTracker.models.LoginCheck;
import com.projectRaj.ExpenseTracker.models.User;
import com.projectRaj.ExpenseTracker.repo.LoginRepository;
import com.projectRaj.ExpenseTracker.repo.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginRepository loginRepository;

    public String registerUser(String userName, String password) {
        // Find the user by username
        User existingUser = userRepository.findByUsername(userName);
        if (existingUser != null) {
            // Handle the case where the username already exists
            return "User with username: " + existingUser.getUsername() + " already exists.";
        }

        try {
            User user = new User();
            String encryptedPassword = PasswordEncryptor.encrypt(password);

            user.setUsername(userName);
            user.setPassword(encryptedPassword);

            // Save the new user
            userRepository.save(user);

            return "User with username: " + user.getUsername() + " successfully registered.";
        } catch (NoSuchAlgorithmException e) {
            // Handle the case where password encryption fails
            return "Internal Server Error while registering, please try again later.";
        }
    }

    public String loginUser(String userName, String password) {
        // Find the user by username
        User user = userRepository.findByUsername(userName);

        if (user == null) {
            // Handle the case where the user does not exist
            return "User not found";
        }

        try {
            String encryptedPassword = PasswordEncryptor.encrypt(password);

            if (user.getPassword().equals(encryptedPassword)) {
                LoginCheck loginCheck = new LoginCheck();
                loginCheck.setLoggedIn(true);
                loginCheck.setUser(user);

                // Save the login record
                loginRepository.save(loginCheck);

                return "Successfully logged in.";
            } else {
                // Handle the case where the password is incorrect
                return "Invalid Credentials.";
            }
        } catch (NoSuchAlgorithmException e) {
            // Handle the case where login fails due to an internal server error
            return "Internal Server Error while logging in, please try again later.";
        }
    }

    public String logOffUser(String userName) {
        // Find the user by username
        User user = userRepository.findByUsername(userName);

        if (user == null) {
            // Handle the case where the user does not exist
            return "User not found";
        }

        Optional<LoginCheck> loggedInUserOptional = loginRepository.findById(user.getId());

        if (loggedInUserOptional.isPresent()) {
            LoginCheck loggedInUser = loggedInUserOptional.get();
            // Log the user off
            loginRepository.delete(loggedInUser);
            return "Successfully logged off.";
        } else {
            // Handle the case where the user is not logged in
            return "User is not currently logged in.";
        }
    }
}
