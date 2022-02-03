package com.stuart.tournament.entity;

import com.stuart.tournament.security.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "player", schema = "mariokart")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String preferredName;

    public Player() {

    }

    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    /**
     * A player may have been involved with many races
     */
    @OneToMany(mappedBy = "player",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<RaceParticipation> participation;

    /**
     * A player may have created a number of tournaments
     */
    @OneToMany(mappedBy = "owningPlayer", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Tournament> ownedTournaments;
}
