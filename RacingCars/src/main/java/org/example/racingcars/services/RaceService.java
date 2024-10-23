package org.example.racingcars.services;

import org.example.racingcars.model.Race;
import org.example.racingcars.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {
    @Autowired
    private RaceRepository raceRepository;

    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    // Fetch races by season
    public List<Race> getRacesBySeason(Long seasonId) {
        return raceRepository.findBySeasonId(seasonId);
    }
}
