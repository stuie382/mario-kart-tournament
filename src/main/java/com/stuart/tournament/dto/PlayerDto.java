package com.stuart.tournament.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Data
public class PlayerDto implements Serializable {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final String preferredName;

    @Transient
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<RaceParticipationDto> participation;

    @Transient
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<TournamentDto> ownedTournaments;
}

