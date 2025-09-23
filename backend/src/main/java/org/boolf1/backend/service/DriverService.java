package org.boolf1.backend.service;

import java.util.List;

import org.boolf1.backend.model.Driver;
import org.boolf1.backend.model.DriverForm;
import org.boolf1.backend.model.Team;
import org.boolf1.backend.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private TeamService teamService;

    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

    public Driver getById(Integer id) {
        return driverRepository.findById(id).get();
    }

    public Driver setDriver(DriverForm driverForm) {
        Team team = teamService.getById(driverForm.getTeamId());

        Driver driver = new Driver();

        driver.setFirstName(driverForm.getFirstName());
        driver.setLastName(driverForm.getLastName());
        driver.setCarNumber(driverForm.getCarNumber());
        driver.setDateBirth(driverForm.getDateBirth());
        driver.setPfpImage(driverForm.getPfpImage());
        driver.setNationality(driverForm.getNationality());
        driver.setTeam(team);

        return driver;
    }

    public Driver store(Driver driver) {
        return driverRepository.save(driver);
    }

    public DriverForm setDriverForm(Driver driver) {
        DriverForm driverForm = new DriverForm();

        driverForm.setId(driver.getId());
        driverForm.setFirstName(driver.getFirstName());
        driverForm.setLastName(driver.getLastName());
        driverForm.setCarNumber(driver.getCarNumber());
        driverForm.setDateBirth(driver.getDateBirth());
        driverForm.setPfpImage(driver.getPfpImage());
        driverForm.setNationality(driver.getNationality());
        driverForm.setTeamId(driver.getTeam().getId());

        return driverForm;
    }

    public Driver update(Driver driver) {
        return driverRepository.save(driver);
    }

    public void deleteById(Integer driverId) {
        driverRepository.deleteById(driverId);
    }
}
