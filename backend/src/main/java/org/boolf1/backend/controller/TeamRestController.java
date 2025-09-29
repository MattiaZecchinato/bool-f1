package org.boolf1.backend.controller;

import java.util.List;

import org.boolf1.backend.model.Team;
import org.boolf1.backend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/teams")
public class TeamRestController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public ResponseEntity<List<Team>> index() {

        List<Team> teamsList = teamService.getAll();

        if (teamsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(teamsList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Team> show(@PathVariable("id") Integer teamId) {

        Team currentTeam = teamService.getById(teamId);

        if (currentTeam == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(currentTeam, HttpStatus.OK);
    }
}
