package com.reliance.gaming.controller;

import com.reliance.gaming.models.*;
import com.reliance.gaming.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private GameService gameService;

    // --- 1. Registration & Progression ---
    @PostMapping("/players") // [cite: 9]
    public Player register(@RequestBody Player player) {
        return gameService.registerPlayer(player);
    }

    @PostMapping("/players/{id}/progression") // [cite: 11]
    public PlayerProgression updateProgression(@PathVariable Long id, @RequestBody PlayerProgression data) {
        return gameService.saveProgression(id, data);
    }

    // --- 2. Leaderboard ---
    @PostMapping("/scores") //
    public GameScore submitScore(@RequestParam Long playerId,
                                 @RequestParam String gameId,
                                 @RequestParam Double score) {
        return gameService.submitScore(playerId, gameId, score);
    }

    @GetMapping("/leaderboard/global") // [cite: 17]
    public List<GameScore> getGlobalLeaderboard(@RequestParam String gameId,
                                                @RequestParam(defaultValue = "10") int limit) {
        return gameService.getTopGlobal(gameId, limit);
    }

    @GetMapping("/leaderboard/country") // [cite: 18]
    public List<GameScore> getCountryLeaderboard(@RequestParam String gameId,
                                                 @RequestParam String country,
                                                 @RequestParam(defaultValue = "10") int limit) {
        return gameService.getTopCountry(gameId, country, limit);
    }

    // --- 3. Events ---
    @PostMapping("/events") //
    public GameEvent createEvent(@RequestBody GameEvent event) {
        return gameService.createEvent(event);
    }

    @PutMapping("/events/{id}") // [cite: 24]
    public GameEvent updateEvent(@PathVariable Long id, @RequestBody GameEvent event) {
        return gameService.updateEvent(id, event);
    }

    @GetMapping("/events/active") //
    public List<GameEvent> getActiveEvents() {
        return gameService.getActiveEvents();
    }
}


//{
//        "id": 0,
//        "deviceId": "string",
//        "userName": "string",
//        "platform": "string",
//        "country": "string",
//        "creationDate": "2026-01-04T07:45:13.152Z",
//        "progression": {
//        "id": 0,
//        "gameLevel": 0,
//        "gameRank": 0,
//        "gold": 0,
//        "cash": 0,
//        "gems": 0,
//        "rewardsCollected": "string",
//        "lastActiveTime": "2026-01-04T07:45:13.152Z",
//        "player": "string"
//        }
//        }