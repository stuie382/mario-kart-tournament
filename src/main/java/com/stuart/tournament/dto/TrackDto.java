package com.stuart.tournament.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackDto implements Serializable {
    private long id;
    private String trackName;
    private String firstAppearance;
}
