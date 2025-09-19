package org.boolf1.backend.model;

import java.time.LocalDate;

public class DriverForm {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer carNumber;
    private LocalDate dateBirth;
    private String pfpImage;
    private String nationality;
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

}
