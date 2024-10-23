package org.example.racingcars.repository;

import org.example.racingcars.model.RaceParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RaceParticipantRepository extends JpaRepository<RaceParticipant, Long> {
    List<RaceParticipant> findByRaceId(Long raceId);
}



