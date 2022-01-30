package com.stuart.tournament.entity;

import lombok.*;

import javax.persistence.*;

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
