package com.reliance.gaming.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "game_events")
public class GameEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Column(length = 1000)
    private String configuration; // JSON string for rewards/eligibility
}