package com.reliance.gaming.service;

import com.reliance.gaming.models.*;
import com.reliance.gaming.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GameService {

    @Autowired private PlayerRepo playerRepo;
    @Autowired private PlayerProgressionRepo progressionRepo;
    @Autowired private GameScoreRepo scoreRepo;
    @Autowired private GameEventRepo eventRepo;

    // --- OBJ 1: Player Registration --- [cite: 9]
    public Player registerPlayer(Player player) {
        player.setCreationDate(LocalDateTime.now());
        return playerRepo.save(player);
    }

    // --- OBJ 1: Save Progression --- [cite: 11]
    public PlayerProgression saveProgression(Long playerId, PlayerProgression data) {
        Player player = playerRepo.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        PlayerProgression existing = progressionRepo.findByPlayerId(playerId)
                .orElse(new PlayerProgression());

        // Update fields
        existing.setPlayer(player);
        existing.setGameLevel(data.getGameLevel());
        existing.setGameRank(data.getGameRank());
        existing.setGold(data.getGold());
        existing.setCash(data.getCash());
        existing.setGems(data.getGems());
        existing.setRewardsCollected(data.getRewardsCollected());
        existing.setLastActiveTime(LocalDateTime.now());

        return progressionRepo.save(existing);
    }

    // --- OBJ 2: Submit Score ---
    public GameScore submitScore(Long playerId, String gameId, Double score) {
        Player player = playerRepo.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        GameScore gameScore = new GameScore();
        gameScore.setPlayer(player);
        gameScore.setGameId(gameId);
        gameScore.setScore(score);
        gameScore.setTimestamp(LocalDateTime.now());

        return scoreRepo.save(gameScore);
    }

    // --- OBJ 2: Leaderboards ---
    public List<GameScore> getTopGlobal(String gameId, int limit) {
        return scoreRepo.findTopScoresByGameId(gameId, PageRequest.of(0, limit));
    }

    public List<GameScore> getTopCountry(String gameId, String country, int limit) {
        return scoreRepo.findTopScoresByGameIdAndCountry(gameId, country, PageRequest.of(0, limit));
    }

    // --- OBJ 3: Game Events --- [cite: 21]
    public GameEvent createEvent(GameEvent event) {
        return eventRepo.save(event);
    }

    public GameEvent updateEvent(Long id, GameEvent details) {
        GameEvent event = eventRepo.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
        event.setName(details.getName());
        event.setStartTime(details.getStartTime());
        event.setEndTime(details.getEndTime());
        event.setConfiguration(details.getConfiguration());
        return eventRepo.save(event);
    }

    public List<GameEvent> getActiveEvents() {
        return eventRepo.findActiveEvents(LocalDateTime.now());
    }
}