# Gaming Backend API

This is a backend system for a mobile game developed using **Spring Boot 3** and **Java 17**. It manages player registration, progression, global/country leaderboards, and game events.

## 🛠 Tech Stack
* **Java 17**
* **Spring Boot 3.x**
* **Spring Data JPA** (Database Interaction)
* **MySQL** (Persistence)
* **Gradle** (Build Tool)
* **SpringDoc OpenAPI** (Swagger UI for testing)

---

## ⚙️ Prerequisites
Before running the application, ensure you have the following installed:
1.  **Java JDK 17** or higher.
2.  **MySQL Server**.

---

## 🚀 Setup & Installation

### 1. Database Setup
The application is configured to automatically create the necessary tables. You only need to create the database schema.

1.  Open your MySQL Command Line or Workbench.
2.  Run the following command:
    ```sql
    CREATE DATABASE gaming_db;
    ```
    *(The application will handle table creation automatically via `ddl-auto=update`)*.

### 2. Configuration
Open `src/main/resources/application.properties` and ensure the database credentials match your local MySQL installation:
```properties
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD