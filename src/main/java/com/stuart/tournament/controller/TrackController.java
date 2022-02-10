package com.stuart.tournament.controller;

import com.stuart.tournament.entity.Track;
import com.stuart.tournament.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tracks")
public class TrackController {

    private static final int PAGE_SIZE = 10;
    private static final int FIRST_PAGE = 1;

    /**
     * Autowired track service instance.
     */
    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    /**
     * Define the end point for tracks/list when accessed with a GET request.
     *
     * @param model The data model to process.
     *
     * @return tracks/list-tracks.html
     */
    @GetMapping("/list")
    public String listTracks(Model model) {
        return findPaginated(model, FIRST_PAGE);
    }

    /**
     * Get the paginated set of tracks from the database.
     *
     * @param model The data model to process
     * @param pageNo The number of the page of tracks you wish to view
     *
     * @return tracks/list-tracks.html
     */
    @GetMapping("/list/{pageNo}")
    public String findPaginated(Model model,
                                @PathVariable(value = "pageNo") int pageNo) {
        Page<Track> trackPages = trackService.findPaginated(PageRequest.of(pageNo - 1, PAGE_SIZE));
        model.addAttribute("tracks", trackPages);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", trackPages.getTotalPages());
        model.addAttribute("totalItems", trackPages.getTotalElements());
        return "tracks/list-tracks";
    }
}
