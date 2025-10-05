package org.boolf1.backend.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DriverForm {

    private Integer id;

    @NotBlank(message = "First name must be not blank or empty")
    private String firstName;

    @NotBlank(message = "Last name must be not blank or empty")
    private String lastName;

    @NotNull(message = "Car number must be not null")
    private Integer carNumber;

    @NotNull(message = "Date of birth must be not null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBirth;

    private String pfpImage;

    @NotBlank(message = "Nationality must be not blank or empty")
    private String nationality;

    @NotNull(message = "Poles positions must be at least 0")
    @Min(value = 0, message = "The pole positions cannot be negative")
    private Integer poles;

    @NotNull(message = "World Championships must be at least 0")
    @Min(value = 0, message = "The World Championships cannot be negative")
    private Integer wdc;

    @NotNull(message = "Podiums must be at least 0")
    @Min(value = 0, message = "The podiums cannot be negative")
    private Integer podiums;

    @NotNull(message = "Wins must be at least 0")
    @Min(value = 0, message = "The wins cannot be negative")
    private Integer wins;

    @NotNull(message = "You must select a team")
    private Integer teamId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCarNumber() {
        return this.carNumber;
    }

    public void setCarNumber(Integer carNumber) {
        this.carNumber = carNumber;
    }

    public LocalDate getDateBirth() {
        return this.dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPfpImage() {
        return this.pfpImage;
    }

    public void setPfpImage(String pfpImage) {
        this.pfpImage = pfpImage;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getTeamId() {
        return this.teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getPoles() {
        return poles;
    }

    public void setPoles(Integer poles) {
        this.poles = poles;
    }

    public Integer getWdc() {
        return wdc;
    }

    public void setWdc(Integer wdc) {
        this.wdc = wdc;
    }

    public Integer getPodiums() {
        return podiums;
    }

    public void setPodiums(Integer podiums) {
        this.podiums = podiums;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }
}
