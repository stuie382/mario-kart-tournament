package com.stuart.tournament.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RaceParticipationIdDto implements Serializable {
    private final Long playerId;
    private final Long raceId;
}
