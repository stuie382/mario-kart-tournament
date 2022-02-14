package com.stuart.tournament.service;

import com.stuart.tournament.entity.Player;
import com.stuart.tournament.entity.Tournament;
import com.stuart.tournament.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class TournamentServiceImpl implements TournamentService {

    private final TournamentRepository tournamentRepository;
    private final PlayerService playerService;

    @Autowired
    public TournamentServiceImpl(TournamentRepository tournamentRepository,
                                 PlayerService playerService) {
        this.tournamentRepository = tournamentRepository;
        this.playerService = playerService;
    }

    @Override
    public Tournament createNewTournament(Tournament tournament, String username) {
        Optional<Player> owningPlayer = playerService.findPlayerByUsername(username);
        if (owningPlayer.isEmpty()) {
            throw new IllegalArgumentException("Username does not exist in the system " + username);
        }
        tournament.setOwningPlayer(owningPlayer.get());
        return tournamentRepository.save(tournament);
    }

    @Override
    public Set<Player> getEligiblePlayersForTournament() {
        return playerService.findAll();
    }


}
