package org.example.racingcars.services;

import org.example.racingcars.model.Championship;
import org.example.racingcars.repository.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionshipService {
    @Autowired
    private ChampionshipRepository championshipRepository;
}
