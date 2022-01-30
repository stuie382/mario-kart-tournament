package com.stuart.tournament.service;

import com.stuart.tournament.entity.Race;
import com.stuart.tournament.repository.RaceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository, ModelMapper modelMapper)
    {
        this.raceRepository = raceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Race> findAll() {
        return null;
    }

}
