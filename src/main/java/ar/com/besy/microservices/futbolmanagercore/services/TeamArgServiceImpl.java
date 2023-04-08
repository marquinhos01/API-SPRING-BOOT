package ar.com.besy.microservices.futbolmanagercore.services;

import ar.com.besy.microservices.futbolmanagercore.model.TeamDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Lazy//se crea solo cuando se usa para evitar lentitud
@Qualifier("Argentina")
@Service //Lo crea por mi, hace el new para que no lo hagamos nosotros, lo marcamos con autowired asi spring lo inyecta
public class TeamArgServiceImpl implements TeamService{

    public Optional<TeamDTO> getTeamById(Integer id){
        TeamDTO teamDTO = new TeamDTO(1, "Tigre");
         Optional<TeamDTO> optionalTeam = Optional.ofNullable(teamDTO);
        return optionalTeam;
    }

}
