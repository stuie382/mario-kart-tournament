package com.stuart.tournament.controller;

import com.stuart.tournament.dto.TrackDto;
import com.stuart.tournament.entity.Track;
import com.stuart.tournament.service.TrackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/tracks")
public class TrackController {

    private static final int PAGE_SIZE = 10;
    private static final int FIRST_PAGE = 1;

    /**
     * Autowired services.
     */
    private final TrackService trackService;
    private final ModelMapper modelMapper;


    @Autowired
    public TrackController(TrackService trackService, ModelMapper modelMapper) {
        this.trackService = trackService;
        this.modelMapper = modelMapper;
    }

    /**
     * Define the end point for tracks/list when accessed with a GET request.
     *
     * @param model The data model to process.
     * @return tracks/list-tracks.html
     */
    @GetMapping("/list")
    public String listTracks(Model model) {
        return findPaginated(model, FIRST_PAGE);
    }

    /**
     * Get the paginated set of tracks from the database.
     *
     * @param model  The data model to process
     * @param pageNo The number of the page of tracks you wish to view
     * @return tracks/list-tracks.html
     */
    @GetMapping("/list/{pageNo}")
    public String findPaginated(Model model,
                                @PathVariable(value = "pageNo") int pageNo) {
        Page<Track> trackPages = trackService.findPaginated(PageRequest.of(pageNo - 1, PAGE_SIZE));
        Page<TrackDto> dtoPages = convertPageTrackToPageDto(trackPages);
        model.addAttribute("tracks", dtoPages);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", trackPages.getTotalPages());
        model.addAttribute("totalItems", trackPages.getTotalElements());
        return "tracks/list-tracks";
    }

    /**
     * Convert the pages of {@link Track} into pages of {@link TrackDto}.
     *
     * @param trackPages - The pages to convert from entity to DTO.
     * @return - A new set of pages using DTOs
     */
    private Page<TrackDto> convertPageTrackToPageDto(Page<Track> trackPages) {
        return new PageImpl<>(trackPages.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList()));
    }

    /**
     * Convert an Entity object into its DTO counterpart.
     *
     * @param entity - The managed entity to convert
     * @return -The DTO version of the entity
     */
    private TrackDto convertToDto(Track entity) {
        return modelMapper.map(entity, TrackDto.class);
    }
}
