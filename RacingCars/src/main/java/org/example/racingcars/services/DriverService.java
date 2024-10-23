package org.example.racingcars.services;

import org.example.racingcars.model.Driver;
import java.util.List;

import org.example.racingcars.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getDriversByTeam(Long teamId) {
        return driverRepository.findDriversByTeamId(teamId);
    }
}

