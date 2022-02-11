package com.stuart.tournament.service;

import com.stuart.tournament.entity.Track;
import com.stuart.tournament.repository.TrackRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Page<Track> findPaginated(Pageable pageable) {
        return trackRepository.findAllByOrderByTrackNameAscFirstAppearanceAsc(pageable);

    }
}
