package com.reliance.gaming.repo;
import com.reliance.gaming.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, Long> {}