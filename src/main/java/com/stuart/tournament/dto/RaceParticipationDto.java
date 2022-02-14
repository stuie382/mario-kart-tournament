package com.stuart.tournament.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RaceParticipationDto {

    private RaceParticipationIdDto id;

    /**
     * The player taking part in the race.
     */
    private PlayerDto player;

    /**
     * The race event.
     */
    private RaceDto race;

    /**
     * The position that the player finished in the race event.
     */
    private Integer position;

}
