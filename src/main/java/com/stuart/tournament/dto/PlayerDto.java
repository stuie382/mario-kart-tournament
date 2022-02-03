package com.stuart.tournament.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PlayerDto implements Serializable {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final String preferredName;
    private List<RaceParticipationDto> participation;
    private List<TournamentDto> ownedTournaments;
}

