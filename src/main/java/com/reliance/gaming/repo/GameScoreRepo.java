package com.reliance.gaming.repo;

import com.reliance.gaming.models.GameScore;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface GameScoreRepo extends JpaRepository<GameScore, Long> {

    // Global Top X
    @Query("SELECT s FROM GameScore s WHERE s.gameId = :gameId ORDER BY s.score DESC")
    List<GameScore> findTopScoresByGameId(String gameId, Pageable pageable);

    // Country Top X
    @Query("SELECT s FROM GameScore s WHERE s.gameId = :gameId AND s.player.country = :country ORDER BY s.score DESC")
    List<GameScore> findTopScoresByGameIdAndCountry(String gameId, String country, Pageable pageable);
}