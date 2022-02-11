package com.stuart.tournament.controller;

import com.stuart.tournament.service.TournamentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;
    private final ModelMapper modelMapper;

    public TournamentController(TournamentService tournamentService,
                                ModelMapper modelMapper) {
        this.tournamentService = tournamentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public String showTournaments() {
        return "tournaments/tournaments";
    }
}
