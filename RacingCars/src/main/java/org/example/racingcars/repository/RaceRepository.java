package org.example.racingcars.repository;

import org.example.racingcars.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
    @Query("SELECT r FROM Race r WHERE r.championship.id = :seasonId")
    List<Race> findBySeasonId(@Param("seasonId") Long seasonId);
}
