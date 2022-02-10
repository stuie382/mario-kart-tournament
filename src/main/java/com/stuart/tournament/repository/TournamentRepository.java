package com.stuart.tournament.repository;

import com.stuart.tournament.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface to allow access to the Tournament data.
 */
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
