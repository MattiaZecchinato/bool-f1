package org.boolf1.backend.service;

import java.util.List;

import org.boolf1.backend.model.Team;
import org.boolf1.backend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public Team getById(Integer id) {
        return teamRepository.findById(id).get();
    }

    public Team store(Team team) {
        return teamRepository.save(team);
    }

    public Team update(Team team) {
        return teamRepository.save(team);
    }

    public void deleteById(Integer driverId) {
        teamRepository.deleteById(driverId);
    }
}
