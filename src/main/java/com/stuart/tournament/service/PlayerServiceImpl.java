package com.stuart.tournament.service;

import com.stuart.tournament.dto.PlayerDto;
import com.stuart.tournament.entity.Player;
import com.stuart.tournament.repository.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;

    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<PlayerDto> findAll() {
        List<Player> players = playerRepository.findAll();
        return players.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private PlayerDto convertToDto(Player entity) {
        return modelMapper.map(entity, PlayerDto.class);
    }
}
