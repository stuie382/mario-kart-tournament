package com.stuart.tournament.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TournamentDto implements Serializable {
    private final Long id;
    private final String tournamentName;
    private final Date date;
    private final PlayerDto owningPlayer;
    private final List<RaceDto> races;
}
