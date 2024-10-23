package org.example.racingcars.controller;
import org.example.racingcars.model.*;
import org.example.racingcars.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private RaceService raceService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private RaceParticipantService participantService;
    @Autowired
    private ChampionshipService championshipService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("races", raceService.getAllRaces());
        model.addAttribute("teams", teamService.getAllTeams());
        return "register";
    }

    @PostMapping("/register")
    public String registerParticipants(
            @RequestParam Long raceId,
            @RequestParam Long teamId,
            @RequestParam List<Long> driverIds,
            Model model,
            RedirectAttributes redirectAttributes) {
        try {
            if (driverIds.size() != 2) {
                redirectAttributes.addFlashAttribute("error", "Hãy chọn từ 2 tay đua");
                return "redirect:/register";
            }

            Race race = raceService.getAllRaces().stream().filter(r -> r.getId().equals(raceId)).findFirst().orElse(null);
            Team team = teamService.getAllTeams().stream().filter(t -> t.getId().equals(teamId)).findFirst().orElse(null);

            for (Long driverId : driverIds) {
                Driver driver = driverService.getDriversByTeam(teamId).stream()
                        .filter(d -> d.getId().equals(driverId))
                        .findFirst()
                        .orElse(null);

                if (driver != null) {
                    RaceParticipant participant = new RaceParticipant(race, team, driver, false);
                    participantService.saveRaceParticipant(participant);
                }
            }
            // Fetch the updated list of participants for the selected race
            List<RaceParticipant> participants = participantService.getParticipantsByRace(raceId);
            model.addAttribute("registeredParticipants", participants);
            model.addAttribute("selectedRace", race);
            redirectAttributes.addFlashAttribute("success", "Đăng ký thành công");
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "You have already registered a race.");
        }
        return "redirect:/register";
    }

    @GetMapping("/getDriversByTeam")
    public String getDriversByTeam(@RequestParam Long teamId, Model model) {
        List<Driver> drivers = driverService.getDriversByTeam(teamId);
        model.addAttribute("drivers", drivers);
        return "fragments/driverList :: driverList";
    }


    @GetMapping("/registered-list")
    public String showRegisteredList(Model model) {
        List<RaceParticipant> registeredParticipants = participantService.findAllParticipants();
        model.addAttribute("registeredParticipants", registeredParticipants);
        return "registered-list"; // Trả về tên view để hiển thị
    }



    @GetMapping("/getRacesBySeason")
    public String getRacesBySeason(@RequestParam Long seasonId, Model model) {
        List<Race> races = raceService.getRacesBySeason(seasonId);
        model.addAttribute("races", races);
        return "fragments/raceList :: raceList";
    }


}
