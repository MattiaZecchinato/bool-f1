package org.boolf1.backend.controller;

import org.boolf1.backend.repository.DriverRepository;
import org.boolf1.backend.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;

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
}
