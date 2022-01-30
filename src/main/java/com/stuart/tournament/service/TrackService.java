package com.stuart.tournament.service;

import com.stuart.tournament.dto.TrackDto;

import java.util.List;

public interface TrackService {

    /**
     * Get a list of all Tracks, sorted alphabetically by track name, and converted into
     * the DTO representation.
     *
     * @return - The alphabetical list of track DTOs
     */
    List<TrackDto> findAll();
}
