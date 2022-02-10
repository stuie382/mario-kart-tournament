package com.stuart.tournament.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "race", schema = "mariokart")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    /**
     * The race participation maps the {@link Player} in each
     * race and the position they finished the race in.
     */
    @OneToMany(mappedBy = "race")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<RaceParticipation> participation;

    /**
     * A race has a name (could be autogenerated) and the date on which the race occurred.
     *
     * @param name - The name of the race
     * @param date - The date the race occurred
     */
    public Race(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    /**
     * The track that the race was held at.
     */
    @OneToOne
    @JoinTable(
            name = "race_tracks",
            joinColumns = @JoinColumn(name = "race_id", referencedColumnName = "id", unique = true),
            inverseJoinColumns = @JoinColumn(name = "track_id")
    )
    private Track track;


}
