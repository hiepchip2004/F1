package org.example.racingcars; // Ensure this package is set correctly

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example.racingcars") // Ensure the base package is specified
public class RacingCarsApplication {
    public static void main(String[] args) {
        SpringApplication.run(RacingCarsApplication.class, args);
    }
}
