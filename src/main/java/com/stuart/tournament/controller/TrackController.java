package com.stuart.tournament.controller;

import com.stuart.tournament.entity.Track;
import com.stuart.tournament.service.TrackService;
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

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/list")
    public String listTracks(Model model) {
        int firstPage = 1;
        return findPaginated(model, firstPage);
    }

    @GetMapping("/list/{pageNo}")
    public String findPaginated(Model model,
                                @PathVariable(value = "pageNo") int pageNo) {
        int pageSize = 10;
        Page<Track> trackPages = trackService.findPaginated(PageRequest.of(pageNo - 1, pageSize));
        model.addAttribute("tracks", trackPages);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", trackPages.getTotalPages());
        model.addAttribute("totalItems", trackPages.getTotalElements());
        return "tracks/list-tracks";
    }
}
