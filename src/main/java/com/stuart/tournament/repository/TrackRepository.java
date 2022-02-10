package com.stuart.tournament.repository;

import com.stuart.tournament.entity.Track;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface to allow access to the track data.
 */
public interface TrackRepository extends JpaRepository<Track, Long> {

    /**
     * Get a list of all tracks sorted in alphabetical order by track name then first appearance.
     *
     * @param pageable - The pages of Tracks
     * @return - The list of tracks in alphabetical order
     */
    Page<Track> findAllByOrderByTrackNameAscFirstAppearanceAsc(Pageable pageable);
}
