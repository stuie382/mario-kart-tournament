package com.stuart.tournament.service;

import com.stuart.tournament.entity.Player;
import com.stuart.tournament.entity.Tournament;

import java.util.Set;

public interface TournamentService {

    Tournament createNewTournament(Tournament dto, String username);

    Set<Player> getEligiblePlayersForTournament();
}
