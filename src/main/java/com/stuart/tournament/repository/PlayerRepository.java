package com.stuart.tournament.repository;

import com.stuart.tournament.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface to allow access to the Player data.
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
