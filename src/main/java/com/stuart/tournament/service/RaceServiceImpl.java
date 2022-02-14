package com.stuart.tournament.service;

import com.stuart.tournament.entity.Race;
import com.stuart.tournament.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public Set<Race> findAll() {
        return null;
    }

}
