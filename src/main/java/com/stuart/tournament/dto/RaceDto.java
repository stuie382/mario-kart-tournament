package com.stuart.tournament.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class RaceDto implements Serializable {
    private final long id;
    private final String name;
    private final Date date;
    private final List<RaceParticipationDto> participation;
    private final TrackDto track;
}
