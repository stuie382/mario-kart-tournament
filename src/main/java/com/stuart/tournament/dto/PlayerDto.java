package com.stuart.tournament.dto;

import lombok.*;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private String preferredName;

    @Transient
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<RaceParticipationDto> participation;

    @Transient
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<TournamentDto> ownedTournaments;
}

