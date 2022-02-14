package com.stuart.tournament.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RaceParticipationIdDto implements Serializable {
    private Long playerId;
    private Long raceId;
}
