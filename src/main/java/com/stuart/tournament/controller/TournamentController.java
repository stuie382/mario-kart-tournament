package com.stuart.tournament.controller;

import com.stuart.tournament.dto.PlayerDto;
import com.stuart.tournament.dto.TournamentDto;
import com.stuart.tournament.entity.Player;
import com.stuart.tournament.entity.Tournament;
import com.stuart.tournament.service.TournamentService;
import com.stuart.tournament.utilities.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;
    private final Mapper mapper;

    public TournamentController(TournamentService tournamentService,
                                Mapper mapper) {
        this.tournamentService = tournamentService;
        this.mapper = mapper;
    }

    /**
     * End point to show the base tournament page. This will allow the user to create a new
     * tournament, see the previous tournaments they have created, and see the tournaments they
     * have been part of.
     *
     * @return tournaments.html
     */
    @GetMapping
    public String showTournaments() {
        return "tournaments/tournaments";
    }

    @GetMapping("/create")
    public String showCreateTournament(Model model) {
        Set<PlayerDto> players = getPlayersForTournament();
        model.addAttribute("theTournament", new TournamentDto());
        model.addAttribute("availablePlayers", players);

        return "tournaments/create-tournaments";
    }

    @PostMapping("/create")
    public String createNewTournament(@ModelAttribute TournamentDto dto, Model model) {
        Tournament entity = mapper.convertSingle(dto, Tournament.class);
        entity = tournamentService.createNewTournament(entity, dto.getOwningUsername());
        TournamentDto persistedDto = mapper.convertSingle(entity, TournamentDto.class);
        model.addAttribute("tournamentDto", persistedDto);
        return "tournaments/play-tournament";
    }

    /**
     * Get a list of all {@link Player} in the system and convert them into DTOs for
     * display to the user.
     *
     * @return A list of Player DTOs to present to the player
     */
    private Set<PlayerDto> getPlayersForTournament() {
        Set<Player> players = tournamentService.getEligiblePlayersForTournament();
        return mapper.convertCollection(players, PlayerDto.class);
    }

}
