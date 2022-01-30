package com.stuart.tournament.service;

import com.stuart.tournament.dto.TrackDto;
import com.stuart.tournament.entity.Track;
import com.stuart.tournament.repository.TrackRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository, ModelMapper modelMapper) {
        this.trackRepository = trackRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TrackDto> findAll() {
        List<Track> tracks = trackRepository.findAllByOrderByTrackNameAscFirstAppearanceAsc();
        return tracks.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());

    }

    /**
     * Convert an Entity object into it's DTO counterpart.
     *
     * @param entity - The managed entity to convert
     * @return -The DTO version of the entity
     */
    private TrackDto convertToDto(Track entity) {
        return modelMapper.map(entity, TrackDto.class);
    }

    /**
     * Convert a DTO object into it's Entity counterpart.
     *
     * @param dto - The DTO to convert
     * @return - The Entity version of the DTO
     */
    private Track convertToEntity(TrackDto dto) {
        return modelMapper.map(dto, Track.class);
    }
}
