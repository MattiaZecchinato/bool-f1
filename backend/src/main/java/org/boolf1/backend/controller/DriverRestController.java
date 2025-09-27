package org.boolf1.backend.controller;

import java.util.List;

import org.boolf1.backend.model.Driver;
import org.boolf1.backend.service.DriverService;
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
@RequestMapping("/api/drivers")
public class DriverRestController {
    @Autowired
    private DriverService driverService;

    @GetMapping
    public ResponseEntity<List<Driver>> index() {

        List<Driver> driversList = driverService.getAll();

        if (driversList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(driversList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> show(@PathVariable("id") Integer driverId) {

        Driver currentDriver = driverService.getById(driverId);

        if (currentDriver == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(currentDriver, HttpStatus.OK);
    }
}
