package com.stuart.tournament.repository;

import com.stuart.tournament.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {

    /**
     * Get a list of all tracks sorted in alphabetical order by track name.
     *
     * @return - The list of tracks in alphabetical order
     */
    List<Track> findAllByOrderByTrackNameAscFirstAppearanceAsc();
}
