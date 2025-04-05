This project demonstrates how to implement JWT (JSON Web Token) authentication using Spring Boot and Spring Security.It provides basic user registration and login endpoints.Upon successful login, a JWT token is generated and returned to the user.The token can be used to access protected endpoints that require authentication.The application uses in-memory H2 database and stores users with encrypted passwords.

User registration is done first. (localhost:8080/login/save)

![image](https://github.com/user-attachments/assets/36a80ba5-b2ae-411f-a471-54f53a6c35fe)

After the registration, the user can log in using the token provided. (localhost:8080/dashboard)

![image](https://github.com/user-attachments/assets/e48bb6b4-ac71-4a7e-b2e3-31419f77b8e6)

To obtain a token, use the login endpoint. (localhost:8080/login/auth)

![image](https://github.com/user-attachments/assets/350210bc-ec60-4409-9b4a-6d3aa25f7db8)

