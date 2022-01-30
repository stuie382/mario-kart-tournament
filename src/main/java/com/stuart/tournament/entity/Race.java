package com.stuart.tournament.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "race", schema = "mariokart")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany(mappedBy = "race")
    private List<RaceParticipation> participation;


    @OneToOne
    @JoinTable(
            name = "race_tracks",
            joinColumns = @JoinColumn(name = "race_id", referencedColumnName = "id", unique = true),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    private Track track;

    public Race() {

    }

    public Race(String name, Date date) {
        this.name = name;
        this.date = date;
    }

}
