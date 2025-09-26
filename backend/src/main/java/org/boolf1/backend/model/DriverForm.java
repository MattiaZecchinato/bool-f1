package org.boolf1.backend.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class DriverForm {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer carNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBirth;
    private String pfpImage;
    private String nationality;
    private Integer poles;
    private Integer wdc;
    private Integer podiums;
    private Integer wins;
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
