package com.stuart.tournament.dto;

import com.stuart.tournament.entity.Player;
import com.stuart.tournament.entity.Race;
import com.stuart.tournament.entity.RaceParticipationId;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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
