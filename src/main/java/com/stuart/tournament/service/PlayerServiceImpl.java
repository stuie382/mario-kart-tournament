package com.stuart.tournament.service;

import com.stuart.tournament.entity.Player;
import com.stuart.tournament.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Optional<Player> findPlayerByUsername(String username) {
        return playerRepository.findPlayerByUsername(username);
    }

    @Override
    public Set<Player> findAll() {
        return playerRepository.findAllByOrderByFirstName();
    }


}
