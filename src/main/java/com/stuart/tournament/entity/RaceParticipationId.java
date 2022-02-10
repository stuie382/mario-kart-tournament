package com.stuart.tournament.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * A compound key of player ID and race ID.
 */
@Embeddable
@NoArgsConstructor
@Data
public class RaceParticipationId implements Serializable {

    @Column(name = "player_id")
    private Long playerId;

    @Column(name = "race_id")
    private Long raceId;
}
