package org.boolf1.backend.controller;

import java.util.NoSuchElementException;

import org.boolf1.backend.model.Team;
import org.boolf1.backend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

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

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("team", new Team());
        model.addAttribute("create", true);

        return "team/createOrEdit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("team") Team formTeam, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("create", true);
            return "team/createOrEdit";
        }

        teamService.store(formTeam);

        return "redirect:/teams";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer teamId, Model model) {

        model.addAttribute("team", teamService.getById(teamId));
        model.addAttribute("create", false);

        return "team/createOrEdit";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("team") Team formTeam, BindingResult bindingResult,
            @PathVariable("id") Integer teamId,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("create", false);
            return "team/createOrEdit";
        }

        teamService.update(formTeam);

        return "redirect:/drivers/" + teamId;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer teamId) {

        if (teamService.getById(teamId) == null) {
            throw new NoSuchElementException("Team not found");
        }

        teamService.deleteById(teamId);

        return "redirect:/teams";
    }
}
