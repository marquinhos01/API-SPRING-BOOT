package ar.com.besy.microservices.futbolmanagercore.services;

import ar.com.besy.microservices.futbolmanagercore.client.TeamClient;
import ar.com.besy.microservices.futbolmanagercore.model.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Lazy
@Primary
@Qualifier("Italy")
@Service
public class TeamItaServiceImpl implements TeamService{

    @Autowired
    private TeamClient teamClient;

    @Override
    public Optional<TeamDTO> getTeamById(Integer id) {
        TeamDTO teamDTO = teamClient.getTeamById(id);
        Optional<TeamDTO> optionalTeam = Optional.ofNullable(teamDTO);
        return optionalTeam;
    }
}
