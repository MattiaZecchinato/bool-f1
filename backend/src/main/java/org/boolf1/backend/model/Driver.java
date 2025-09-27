package org.boolf1.backend.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBirth;

    @Column(name = "pfp_image")
    private String pfpImage;

    @NotBlank(message = "Nationality must be not blank or empty")
    private String nationality;

    @NotNull(message = "Poles positions must be at least 0")
    @Min(value = 0, message = "The pole positions cannot be negative")
    @Column(name = "pole_positions")
    private Integer poles;

    @NotNull(message = "World Championships must be at least 0")
    @Min(value = 0, message = "The World Championships cannot be negative")
    @Column(name = "world_championships")
    private Integer wdc;

    @NotNull(message = "Podiums must be at least 0")
    @Min(value = 0, message = "The podiums cannot be negative")
    private Integer podiums;

    @NotNull(message = "Wins must be at least 0")
    @Min(value = 0, message = "The wins cannot be negative")
    private Integer wins;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
