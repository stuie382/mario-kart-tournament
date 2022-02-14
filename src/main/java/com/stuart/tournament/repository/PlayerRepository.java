package com.stuart.tournament.repository;

import com.stuart.tournament.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

/**
 * The interface to allow access to the Player data.
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findPlayerByUsername(String username);

    Set<Player> findAllByOrderByFirstName();
}
