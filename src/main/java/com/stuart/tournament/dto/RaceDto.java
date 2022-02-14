package com.stuart.tournament.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RaceDto implements Serializable {
    private long id;
    private String name;
    private Date date;
    private Set<RaceParticipationDto> participation;
    private TrackDto track;
}
