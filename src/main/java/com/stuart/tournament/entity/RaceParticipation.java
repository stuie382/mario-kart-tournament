package com.stuart.tournament.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "race_participation")
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

    public RaceParticipation(Race race, Integer position) {
        this.race = race;
        this.position = position;
    }
}

