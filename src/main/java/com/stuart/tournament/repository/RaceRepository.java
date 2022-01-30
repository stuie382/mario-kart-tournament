package com.stuart.tournament.repository;

import com.stuart.tournament.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {
}
