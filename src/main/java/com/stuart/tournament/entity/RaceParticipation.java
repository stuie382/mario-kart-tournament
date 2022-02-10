package com.stuart.tournament.entity;

import lombok.*;

import javax.persistence.*;

/**
 * A mapping of players, and their final position, to races.
 */
@Entity
@Table(name = "race_participation", schema = "mariokart")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class RaceParticipation {

    @EmbeddedId
    private RaceParticipationId id;

    /**
     * The player taking part in the race.
     */
    @MapsId("player_id")
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    /**
     * The race event.
     */
    @MapsId("race_id")
    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;

    /**
     * The position that the player finished in the race event.
     */
    private Integer position;

}
