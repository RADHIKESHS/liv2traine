# Liv2Train Registry

## Overview

**Liv2Train** is a registry for government-funded training centers. This MVP application is built using Spring Boot and MySQL. It supports two main APIs:

- **POST /api/add-training-center**: Create and save new training centers.
- **GET /api/getall-training-centers**: Retrieve the list of all stored training centers.

The project ensures proper validation, structured exception handling, and follows best coding practices.

## Features

- Create new training centers with fields such as center name, center code, address, student capacity, courses offered, contact details, and creation timestamp.
- Retrieve a list of all stored training centers.
- Full validation of incoming data, including constraints on field length, formats, and required fields.
- Structured exception handling with meaningful error responses.

## Swagger UI

- **Swagger UI :**
  ```swagger-UI-endpoint
  http://localhost:8080/swagger-ui/index.html#/
  ```
  ![Swagger UI](https://github.com/RADHIKESHS/liv2traine/blob/main/swagger-ui.png)


## Tech Stack

- **Java 17**
- **Spring Boot**
- **MySQL** as the database
- **JPA/Hibernate** for ORM
- **Maven** for build automation
- **Lombok** for reducing boilerplate code
- **Validation Annotations** for validating input data

## Prerequisites

To run this project locally, you need the following tools installed:

- Java 17
- Maven 3.x
- MySQL 8.x
- An IDE (e.g., IntelliJ IDEA, Eclipse)

## Setup Instructions

### 1. Clone the Repository

```bash
  git clone https://github.com/RADHIKESHS/liv2traine.git
  cd liv2train
```
### 2. Configure the Database

- **Create a MySQL Database:**
  ```bash
    CREATE DATABASE liv2train_db;
  ```
- Add this in Application.propertyfile
  ```sql
  spring.datasource.url=jdbc:mysql://localhost:3306/liv2train_db
  spring.datasource.username=your_mysql_username
  spring.datasource.password=your_mysql_password
  spring.jpa.hibernate.ddl-auto=update
  ```

### 3. Build and Run the Application
  ```bash
    mvn clean install
    mvn spring-boot:run
  ```
## API Endpoints
### 4. Create a Training Center (POST /api/add-training-center)
- Request Body Example:
  ```
    {
    "centerName": "Tech Academy",
    "centerCode": "ABC123456789",
    "address": {
      "detailedAddress": "Tech Street",
      "city": "Tech City",
      "state": "TS",
      "pincode": "123456"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Java", "Spring Boot"],
    "contactEmail": "info@techacademy.com",
    "contactPhone": "1234567890"
  }
  ```
- Response Example:

  ```
    {
    "centerName": "Tech Academy",
    "centerCode": "ABC123456789",
    "address": {
      "detailedAddress": "Tech Street",
      "city": "Tech City",
      "state": "TS",
      "pincode": "123456"
    },
    "studentCapacity": 100,
    "coursesOffered": ["Java", "Spring Boot"],
    "contactEmail": "info@techacademy.com",
    "contactPhone": "1234567890"
  }
  ```
### 5. Retrieve All Training Centers (GET /api/getall-training-centers)
- Response Example:
```
  [
    {
      "centerName": "Tech Academy",
      "centerCode": "ABC123456789",
      "address": {
        "detailedAddress": "Tech Street",
        "city": "Tech City",
        "state": "TS",
        "pincode": "123456"
      },
      "studentCapacity": 100,
      "coursesOffered": ["Java", "Spring Boot"],
      "createdOn": 1694078400000,
      "contactEmail": "info@techacademy.com",
      "contactPhone": "1234567890"
    }
  ]
```

### 6. Error Handling
## Validation Error Responses
- MethodArgumentNotValidException:
- When validation fails, the response will include a list of validation error messages, such as:

```
  {
    "timestamp": "2024-09-06T22:20:06.1858442",
    "message": "Validation failed",
    "errors": [
      "Field 'pincode': Invalid pincode"
    ]
  }
```

- ConstraintViolationException:
- When a constraint violation occurs, the response will include a list of error messages related to the constraint violations, such as:

```
  {
    "timestamp": "2024-09-06T22:20:06.1858442",
    "message": "Constraint violations",
    "errors": [
      "Field 'pincode': Invalid pincode"
    ]
  }
```

### 7. Contributing
## Feel free to submit issues or pull requests. Please make sure your contributions adhere to the project's coding standards.

- 1. Fork the repository.
  2. Create a new branch:
     ```bash
     git checkout -b feature-branch
     ```
  3. Commit your changes:
    ```
      git commit -m 'Add new feature'
    ```
  4. Push to the branch:
    ```
      git push origin feature-branch
    ```
  5. Open a pull request.


