package com.reliance.gaming.repo;

import com.reliance.gaming.models.GameEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDateTime;
import java.util.List;

public interface GameEventRepo extends JpaRepository<GameEvent, Long> {

    // Get Available (Valid events w.r.t time)
    @Query("SELECT e FROM GameEvent e WHERE :now BETWEEN e.startTime AND e.endTime")
    List<GameEvent> findActiveEvents(LocalDateTime now);
}