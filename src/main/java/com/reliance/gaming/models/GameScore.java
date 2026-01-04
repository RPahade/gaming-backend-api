package com.reliance.gaming.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "game_scores")
public class GameScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gameId;
    private Double score;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
}