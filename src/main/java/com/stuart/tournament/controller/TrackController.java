package com.stuart.tournament.controller;

import com.stuart.tournament.dto.TrackDto;
import com.stuart.tournament.service.TrackService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Controller
@RequestMapping("/tracks")
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/list/")
    public String listTracks(Model model,
                             @RequestParam("pageNumber") Optional<Integer> pageNumber,
                             @RequestParam("size") Optional<Integer> size) {
        int currentPage = pageNumber.orElse(1);
        int pageSize = size.orElse(50);
        Page<TrackDto> trackPages = trackService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("tracks", trackPages);
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", trackPages.getTotalPages());
        model.addAttribute("totalItems", trackPages.getTotalElements());
        return "tracks/list-tracks";
    }


}
