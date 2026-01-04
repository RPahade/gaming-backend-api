package com.reliance.gaming.repo;
import com.reliance.gaming.models.PlayerProgression;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PlayerProgressionRepo extends JpaRepository<PlayerProgression, Long> {
    Optional<PlayerProgression> findByPlayerId(Long playerId);
}