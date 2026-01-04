package com.reliance.gaming.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name = "player_progression")
public class PlayerProgression {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer gameLevel; // "level" is a reserved keyword in some SQL
    private Integer gameRank;
    private Double gold;
    private Double cash;
    private Double gems;
    private String rewardsCollected; // Storing as JSON string or comma-separated for simplicity
    private LocalDateTime lastActiveTime;

    @OneToOne
    @JoinColumn(name = "player_id")
    @JsonIgnore
    private Player player;
}