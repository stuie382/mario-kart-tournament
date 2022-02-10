package com.stuart.tournament.service;

import com.stuart.tournament.dto.TournamentDto;
import com.stuart.tournament.entity.Tournament;
import com.stuart.tournament.repository.TournamentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentServiceImpl implements TournamentService {

    private final TournamentRepository tournamentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TournamentServiceImpl(TournamentRepository tournamentRepository,
                                 ModelMapper modelMapper) {
        this.tournamentRepository = tournamentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TournamentDto> findAll() {
        List<Tournament> tournaments = tournamentRepository.findAll();
        return tournaments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private TournamentDto convertToDto(Tournament entity) {
        return modelMapper.map(entity, TournamentDto.class);
    }


}
