package org.boolf1.backend.controller;

import org.boolf1.backend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public String index(Model model) {

        model.addAttribute("teamsList", teamService.getAll());

        return "team/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer teamId, Model model) {

        model.addAttribute("teamStats", teamService.getById(teamId));

        return "team/teamStatistics";
    }
}
