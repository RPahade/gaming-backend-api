package com.reliance.gaming.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceId;
    private String userName;
    private String platform; // iOS, Android
    private String country; // Added for Country Leaderboard [cite: 12, 18]
    private LocalDateTime creationDate;

    // Optional: One-to-One mapping with progression
    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    private PlayerProgression progression;
}