package com.stuart.tournament.entity;

import lombok.*;

import javax.persistence.*;

/**
 * The track has a name and the details of which game in the series it first appeared in.
 */
@Entity
@Table(name = "track", schema = "mariokart")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String trackName;
    private String firstAppearance;

    public Track(String trackName, String firstAppearance) {
        this.trackName = trackName;
        this.firstAppearance = firstAppearance;
    }
}
