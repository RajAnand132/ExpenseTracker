# <h1 align="center">Expense Tracker</h1>
<p align="center">
  <a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
  </a>
  <a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
  </a>
  <a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.3-brightgreen.svg" />
  </a>
   <img alt = "GPL v3" src="https://img.shields.io/badge/License-GPLv3-blue.svg" />
</p>

---

<p align="left">


## Introduction
Expense Tracker is a Spring Boot-based API that allows users to track their expenses. Users can perform various operations like creating, reading, updating, and deleting expenses. Additionally, it offers features like generating reports and tracking expenses by date, ensuring user authentication and registration.

## Features

- **User Management**: Users can register and log in to access their expense data.
- **Expense Management**: Users can create, read, update, and delete expenses.
- **Expense Retrieval**: Retrieve expenses by date, ensuring that users only access their own expenses.
- **Password Requirements**: Enforce password requirements, including at least one uppercase letter, one lowercase letter, one special character, and one digit.
- **Security**: Passwords are securely stored with encryption.
- **Error Handling**: Proper error handling for various scenarios.
- **Persistence**: Data is stored in a MySQL database.
- **Static IP Address**: Ensure a static IP address for the deployment server.

## API Endpoints

### Users Controller

- **POST /users/signUp**: Register a new user.
  - Response: Successful registration message or an error message (like "Username already exists").
  
- **POST /users/signIn**: Log in as a registered user.
  - Response: Successful login message or an error message (like "Invalid credentials").
  
- **POST /users/singnOut**: Log off as a logged-in user.
  - Response: Successful logoff message or an error message.

### Expenses Controller

- **POST /expenses**: Create a new expense.
  - Response: Successful addition message or an error message.

  **Request Body**
    ```JSON Body
  {
      "title": "Dinner",
      "description": "Dinner at a restaurant",
      "price": 50.0,
      "date": "2023-10-22",
      "time": "19:45:03",
      "user": {
        "id": 1
      }
  }
    ```

  
- **GET /expenses/date/{date}**: Retrieve expenses for a specific date.
  - Response: List of expenses or an error message (like "No expenses found for the given date").
  
- **PUT /expenses/{id}**: Update an existing expense.
  - Response: Successful update message or an error message (like "Expense does not belong to the user").
  
- **DELETE /expenses/{id}**: Delete an expense.
  - Response: Successful deletion message or an error message (like "Expense not found").


## Security Considerations

- User passwords are stored securely with encryption.
- Passwords must meet specific requirements for user registration.
- Users are required to log in to access their expenses and perform actions.



## Contributing

Contributions to this project are welcome. If you have any suggestions, improvements, or feature requests, please create a pull request or open an issue.

Thank you for considering this backend design as a starting point for your Expense Tracker. Good luck with your project!



## Swagger Configuration
**LocalHost**
```
http://localhost:8080/swagger-ui/index.html#/
```

**Public Address**
```
http://13.235.114.20:8080/swagger-ui/index.html#/
```

## Contact Information

If you have any questions, issues, or need further assistance related to the  Expense Tracker Portal project, feel free to contact us. We are here to help!

- **Raj Anand**
  - Email: rajanandirctc@gmail.com
  - LinkedIn: [Raj Anand's LinkedIn Profile]()
  - GitHub: [Raj Anand's GitHub Profile]()


Please don't hesitate to reach out if you have any inquiries or need assistance with any aspect of the project. Your feedback and questions are important to us.



