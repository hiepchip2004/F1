package org.example.racingcars.services;

import org.example.racingcars.model.RaceParticipant;
import org.example.racingcars.repository.RaceParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceParticipantService {

    @Autowired
    private RaceParticipantRepository participantRepository;

    public void saveRaceParticipant(RaceParticipant participant) {
        participantRepository.save(participant);
    }

    public List<RaceParticipant> getParticipantsByRace(Long raceId) {
        return participantRepository.findByRaceId(raceId);
    }


    public List<RaceParticipant> findAllParticipants() {
        return participantRepository.findAll();
    }

}


