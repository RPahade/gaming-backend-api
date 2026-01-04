# Gaming Backend API Assignment

This project is a Spring Boot backend system for a mobile game, utilizing **Java 17**, **Spring Data JPA**, and **MySQL**. It handles player registration, progression tracking, real-time leaderboards, and game events.

## 📋 Prerequisites
* **Java 17** (JDK)
* **MySQL Server**
* **Gradle** (handled via wrapper)

## 🛠 Database Setup
1.  Open your MySQL terminal or Workbench.
2.  Run the provided SQL script or manually execute:
    ```sql
    CREATE DATABASE gaming_db;
    ```
3.  Update `src/main/resources/application.properties` with your MySQL credentials:
    ```properties
    spring.datasource.username=root
    spring.datasource.password=YOUR_PASSWORD
    ```

## 🚀 How to Run the JAR File
1.  **Build the JAR:**
    Open a terminal in the project folder and run:
    ```bash
    ./gradlew bootJar
    ```
2.  **Run the Application:**
    Navigate to the build directory and execute the JAR:
    ```bash
    cd build/libs
    java -jar gaming-backend-0.0.1-SNAPSHOT.jar
    ```
3.  The server will start at `http://localhost:8080`.

## 📖 API Documentation (Step-by-Step Check)

You can verify all workings via Swagger UI: **http://localhost:8080/swagger-ui/index.html**

### 1. User Registration [Compulsory]
**Endpoint:** `POST /api/players`
* **Description:** Registers a new player with device and location info.
* **Sample Body:**
    ```json
    {
      "userName": "SkyWalker",
      "deviceId": "D-101",
      "platform": "Android",
      "country": "India"
    }
    ```

### 2. Player Progression [Compulsory]
**Endpoint:** `POST /api/players/{id}/progression`
* **Description:** Saves level, currency, and rewards.
* **Sample Body:**
    ```json
    {
      "gameLevel": 12,
      "gold": 5000.0,
      "gems": 150.0,
      "rewardsCollected": "StarterPack"
    }
    ```

### 3. Leaderboards [Compulsory]
**Endpoint:** `POST /api/scores` (Submit Score)
* **Params:** `playerId=1`, `gameId=PubG`, `score=1200`

**Endpoint:** `GET /api/leaderboard/global` (Top Players Global)
* **Params:** `gameId=PubG`, `limit=10`

**Endpoint:** `GET /api/leaderboard/country` (Top Players by Country)
* **Params:** `gameId=PubG`, `country=India`

### 4. Game Event System [Optional]
**Endpoint:** `POST /api/events` (Schedule Event)
* **Sample Body:**
    ```json
    {
      "name": "Summer Clash",
      "startTime": "2024-01-01T10:00:00",
      "endTime": "2025-01-01T10:00:00",
      "configuration": "{\"prize\": \"1000 Gems\"}"
    }
    ```
**Endpoint:** `GET /api/events/active` (Get currently valid events)