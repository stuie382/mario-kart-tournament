package com.stuart.tournament.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The tournament is owned by a single player, and comprises one or more race events.
 */
@Entity
@Table(name = "tournament", schema = "mariokart")
@NoArgsConstructor
@Data
public class Tournament {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * A name for the tournament.
     */
    private String tournamentName;

    /**
     * The date the tournament was held, or the opening day if it runs for multiple days.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    /**
     * A tournament would have been created by a player. This player may have created
     * multiple tournaments.
     */
    @ManyToOne
    @JoinTable(name = "torunament_ownership",
            joinColumns = @JoinColumn(name = "tournament_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"))
    private Player owningPlayer;

    /**
     * The races that make up the tournament.
     */
    @OneToMany
    @JoinTable(
            name = "tournament_races",
            joinColumns = @JoinColumn(name = "tournament_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "race_id", referencedColumnName = "id")
    )
    private List<Race> races;
}
