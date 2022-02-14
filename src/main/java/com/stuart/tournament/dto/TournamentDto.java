package com.stuart.tournament.dto;

import com.stuart.tournament.entity.Player;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
public class TournamentDto implements Serializable {
    private Long id;
    private String tournamentName;
    private LocalDate date;
    private String owningUsername;
    private Set<RaceDto> races;
    private Set<Player> players;
}
