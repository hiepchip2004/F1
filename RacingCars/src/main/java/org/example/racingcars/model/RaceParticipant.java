package org.example.racingcars.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RaceParticipants")
public class RaceParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    private boolean isPrimaryDriver;

    // Add a custom constructor (excluding id)
    public RaceParticipant(Race race, Team team, Driver driver, boolean isPrimaryDriver) {
        this.race = race;
        this.team = team;
        this.driver = driver;
        this.isPrimaryDriver = isPrimaryDriver;
    }
}

