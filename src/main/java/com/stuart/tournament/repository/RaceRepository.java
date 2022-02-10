package com.stuart.tournament.repository;

import com.stuart.tournament.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface to allow access to the Race data
 */
public interface RaceRepository extends JpaRepository<Race, Long> {
}
