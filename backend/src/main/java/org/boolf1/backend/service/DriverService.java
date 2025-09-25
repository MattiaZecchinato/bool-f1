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

    public Driver mapFormToDriver(DriverForm driverForm, Driver driver) {
        Team team = teamService.getById(driverForm.getTeamId());

        driver.setFirstName(driverForm.getFirstName());
        driver.setLastName(driverForm.getLastName());
        driver.setCarNumber(driverForm.getCarNumber());
        driver.setDateBirth(driverForm.getDateBirth());
        driver.setPfpImage(driverForm.getPfpImage());
        driver.setNationality(driverForm.getNationality());
        driver.setTeam(team);

        return driver;
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

    public Driver store(DriverForm formDriver) {
        // set Driver to DTO DriverForm
        Driver newDriver = mapFormToDriver(formDriver, new Driver());

        return driverRepository.save(newDriver);
    }

    public Driver update(DriverForm formDriver) {
        Driver updatingDriver = getById(formDriver.getId());

        // set Driver to DTO DriverForm
        mapFormToDriver(formDriver, updatingDriver);

        return driverRepository.save(updatingDriver);
    }

    public void deleteById(Integer driverId) {
        driverRepository.deleteById(driverId);
    }
}
