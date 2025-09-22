package org.boolf1.backend.controller;

import java.util.NoSuchElementException;

import org.boolf1.backend.model.Driver;
import org.boolf1.backend.model.DriverForm;
import org.boolf1.backend.service.DriverService;
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
@RequestMapping("/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @Autowired
    private TeamService teamService;

    @GetMapping
    public String index(Model model) {

        model.addAttribute("driversList", driverService.getAll());

        return "driver/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer driverId, Model model) {

        model.addAttribute("driverStats", driverService.getById(driverId));

        return "driver/driverStatistics";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("driver", new DriverForm());
        model.addAttribute("create", true);
        model.addAttribute("teamsList", teamService.getAll());

        return "driver/createOrEdit";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("driver") DriverForm formDriver, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("create", true);
            return "driver/createOrEdit";
        }

        // set Driver to DTO DriverForm
        Driver driver = driverService.setDriver(formDriver);

        driverService.store(driver);

        return "redirect:/drivers";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer driverId, Model model) {

        Driver driver = driverService.getById(driverId);

        // set DTO DriverForm to Driver
        model.addAttribute("driver", driverService.setDriverForm(driver));
        model.addAttribute("create", false);
        model.addAttribute("teamsList", teamService.getAll());

        return "driver/createOrEdit";
    }

    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("driver") DriverForm formDriver, BindingResult bindingResult,
            @PathVariable("id") Integer driverId,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("create", false);
            return "driver/createOrEdit";
        }

        // set Driver to DTO DriverForm
        Driver driver = driverService.setDriver(formDriver);

        driverService.update(driver);

        return "redirect:/drivers/" + driverId;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer driverId) {

        if (driverService.getById(driverId) == null) {
            throw new NoSuchElementException("Driver not found");
        }

        driverService.deleteById(driverId);

        return "redirect:/drivers";
    }
}
