package com.stuart.tournament.entity;

import com.stuart.tournament.security.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "player", schema = "mariokart")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String username;

    /**
     * A player links the game context to a {@link User}.
     */
    public Player(String firstName, String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    /**
     * A player may have been involved with many races
     */
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<RaceParticipation> participation;

    /**
     * A player may have created a number of tournaments
     */
    @OneToMany(mappedBy = "owningPlayer", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Tournament> ownedTournaments;
}
