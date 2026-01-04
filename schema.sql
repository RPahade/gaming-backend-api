-- Database Creation Script
CREATE DATABASE IF NOT EXISTS gaming_db;

USE gaming_db;

-- NOTE: The application is configured to auto-generate tables.
-- However, running the application will create the following structure:

-- 1. Players Table
CREATE TABLE IF NOT EXISTS players (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    device_id VARCHAR(255),
    user_name VARCHAR(255),
    platform VARCHAR(255),
    country VARCHAR(255),
    creation_date DATETIME(6)
);

-- 2. Player Progression Table
CREATE TABLE IF NOT EXISTS player_progression (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    game_level INT,
    game_rank INT,
    gold DOUBLE,
    cash DOUBLE,
    gems DOUBLE,
    rewards_collected VARCHAR(255),
    last_active_time DATETIME(6),
    player_id BIGINT,
    FOREIGN KEY (player_id) REFERENCES players(id)
);

-- 3. Game Scores Table (for Leaderboards)
CREATE TABLE IF NOT EXISTS game_scores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    game_id VARCHAR(255),
    score DOUBLE,
    timestamp DATETIME(6),
    player_id BIGINT,
    FOREIGN KEY (player_id) REFERENCES players(id)
);

-- 4. Game Events Table
CREATE TABLE IF NOT EXISTS game_events (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    start_time DATETIME(6),
    end_time DATETIME(6),
    configuration VARCHAR(1000)
);