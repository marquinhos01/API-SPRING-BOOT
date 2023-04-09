package ar.com.besy.microservices.futbolmanagercore.services;

import ar.com.besy.microservices.futbolmanagercore.model.TeamDTO;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    public Optional<TeamDTO> getTeamById(Integer id);

    public List<TeamDTO> findAllTeams();
    public Integer saveTeam(TeamDTO teamDTO);
    public void deleteById(Integer id);


}
