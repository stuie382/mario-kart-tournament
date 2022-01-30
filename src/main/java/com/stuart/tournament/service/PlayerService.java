package com.stuart.tournament.service;

import com.stuart.tournament.dto.PlayerDto;

import java.util.List;

public interface PlayerService {

    List<PlayerDto> findAll();
}
