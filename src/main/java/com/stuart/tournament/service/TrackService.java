package com.stuart.tournament.service;

import com.stuart.tournament.entity.Track;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TrackService {


    Page<Track> findPaginated(Pageable pageable);
}
