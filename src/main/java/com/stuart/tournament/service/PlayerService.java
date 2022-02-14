package com.stuart.tournament.service;

import com.stuart.tournament.entity.Player;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PlayerService {

    Optional<Player> findPlayerByUsername(String username);

    Set<Player> findAll();
}
