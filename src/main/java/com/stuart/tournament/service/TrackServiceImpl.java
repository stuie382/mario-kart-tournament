package com.stuart.tournament.service;

import com.stuart.tournament.dto.TrackDto;
import com.stuart.tournament.entity.Track;
import com.stuart.tournament.repository.TrackRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<TrackDto> findPaginated(Pageable pageable) {

        List<TrackDto> all = trackRepository.findAll(pageable)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new PageImpl<>(all, pageable, all.size());

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
//        int pageSize = pageable.getPageSize();
//        int currentPage = pageable.getPageNumber();
//        int startItem = currentPage * pageSize;
//        List<TrackDto> list;
//        List<TrackDto> tracks = findAll();
//
//        if (tracks.size() < startItem) {
//            list = Collections.emptyList();
//        } else {
//            int toIndex = Math.min(startItem + pageSize, tracks.size());
//            list = tracks.subList(startItem, toIndex);
//        }
//        return new PageImpl<TrackDto>(list, PageRequest.of(currentPage, pageSize), tracks.size());