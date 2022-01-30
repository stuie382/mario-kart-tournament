package com.stuart.tournament.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class TrackDto implements Serializable {
    private long id;
    private String trackName;
    private String firstAppearance;
}
