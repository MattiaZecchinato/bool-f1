package org.boolf1.backend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "First name must be not blank or empty")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "First name must be not blank or empty")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Car number must be not null")
    @Column(name = "car_number")
    private Integer carNumber;

    @NotNull(message = "Date of birth must be not null")
    @Column(name = "date_birth")
    private LocalDate dateBirth;

    @Column(name = "pfp_image")
    private String pfpImage;

    @NotBlank(message = "Nationality must be not blank or empty")
    private String nationality;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(Integer carNumber) {
        this.carNumber = carNumber;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPfpImage() {
        return pfpImage;
    }

    public void setPfpImage(String pfpImage) {
        this.pfpImage = pfpImage;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
