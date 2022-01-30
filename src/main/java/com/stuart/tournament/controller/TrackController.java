package com.stuart.tournament.controller;

import com.stuart.tournament.dto.TrackDto;
import com.stuart.tournament.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tracks")
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/list")
    public String listTracks(Model model) {
        List<TrackDto> tracks = trackService.findAll();
        model.addAttribute("tracks", tracks);
        return "tracks/list-tracks";
    }


}
