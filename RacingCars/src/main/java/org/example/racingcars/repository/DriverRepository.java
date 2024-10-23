package org.example.racingcars.repository;

import org.example.racingcars.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    // Custom query using JPQL
    @Query("SELECT d FROM Driver d WHERE d.team.id = :teamId")
    List<Driver> findDriversByTeamId(@Param("teamId") Long teamId);


}
