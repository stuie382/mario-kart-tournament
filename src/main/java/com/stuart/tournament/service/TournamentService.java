package com.stuart.tournament.service;

import com.stuart.tournament.dto.TournamentDto;

import java.util.List;

public interface TournamentService {

    List<TournamentDto> findAll();
}
