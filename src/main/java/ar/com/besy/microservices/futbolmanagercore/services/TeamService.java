package ar.com.besy.microservices.futbolmanagercore.services;

import ar.com.besy.microservices.futbolmanagercore.model.TeamDTO;

import java.util.Optional;

public interface TeamService {
    public Optional<TeamDTO> getTeamById(Integer id);
}
