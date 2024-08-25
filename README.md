# Leave Management System

This is a simple Leave Management System built using Spring Boot. The system allows employees to apply for leaves and managers to manage those leave requests. The project is structured with a service layer, DTOs, repository, exception handling, and security configuration.

## Table of Contents

- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Features](#features)
- [APIs](#apis)
- [Roles and Security](#roles-and-security)
- [Setup Instructions](#setup-instructions)
- [License](#license)

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Lombok
- H2 Database (for in-memory storage)
- Maven

## Project Structure

The project follows a typical layered architecture:

- **Model Layer:** Contains entity classes.
- **DTO Layer:** Data Transfer Objects for API communication.
- **Repository Layer:** Interface extending JPARepository.
- **Service Layer:** Business logic implementation.
- **Controller Layer:** REST APIs.
- **Exception Layer:** Custom exceptions.
- **Config Layer:** Security configuration.
- **DTO Package:** Contains Data Transfer Objects with Lombok annotations.

## Features

- Apply for a leave.
- Fetch leave details by ID.
- Fetch all leaves.
- Fetch all accepted/rejected leaves.
- Update leave details.
- Delete leave records.
- Manager-only APIs for accepting/rejecting leave requests.
- In-memory user management with roles: **EMPLOYEE** and **MANAGER**.
- Role-based access control using Spring Security.
- Method-level security.

## APIs

### Public APIs (Accessible by both EMPLOYEE and MANAGER roles)

- **GET /api/leave/{id}**: Fetch a Leave record by its ID.
- **GET /api/leave/all**: Fetch all Leave records.
- **GET /api/leave/accepted**: Fetch all accepted Leave records.
- **GET /api/leave/rejected**: Fetch all rejected Leave records.
- **GET /api/leave/status/{id}**: Fetch a Leave record status by its ID.
- **PUT /api/leave/{id}**: Update a Leave record by its ID.
- **DELETE /api/leave/{id}**: Delete a Leave record by its ID.
- **POST /api/leave/apply**: Apply for a leave.

### Manager-Only APIs (Accessible only by MANAGER role)

- **POST /api/leave/accept/{id}**: Accept a Leave record by its ID.
- **POST /api/leave/reject/{id}**: Reject a Leave record by its ID.

## Roles and Security

- **EMPLOYEE Role**: Can apply for leaves, view leave details, update leave details, and delete leave records.
- **MANAGER Role**: Has all EMPLOYEE permissions, plus the ability to accept or reject leave requests.

### Method-Level Security

Method-level security is enabled across all APIs, ensuring that only users with the right roles can access specific endpoints.

## Setup Instructions

1. **Clone the Repository:**

```bash
git clone https://github.com/yourusername/leave-management-system.git
cd leave-management-system
```

2. **Configure the Database:**

    Update the database settings in `src/main/resources/application.yml` to match your local environment.

3. **Build the Project:**

    ```bash
    mvn clean install
    ```

4. **Run the Application:**

    ```bash
    mvn spring-boot:run
    ```
