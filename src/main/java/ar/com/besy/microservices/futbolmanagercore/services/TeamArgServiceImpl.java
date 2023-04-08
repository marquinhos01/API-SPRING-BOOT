package ar.com.besy.microservices.futbolmanagercore.services;

import ar.com.besy.microservices.futbolmanagercore.model.TeamDTO;
import ar.com.besy.microservices.futbolmanagercore.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Lazy//se crea solo cuando se usa para evitar lentitud
@Qualifier("Argentina")
@Service //Lo crea por mi, hace el new para que no lo hagamos nosotros, lo marcamos con autowired asi spring lo inyecta
public class TeamArgServiceImpl implements TeamService {

    //me levanto el repositorio
    @Autowired
    private TeamRepository teamRepository;

    public Optional<TeamDTO> getTeamById(Integer id) {
        //TeamDTO teamDTO = new TeamDTO(1, "Tigre");
        //Optional<TeamDTO> optionalTeam = Optional.ofNullable(teamDTO);

        Optional<TeamDTO> optionalTeam = teamRepository.findById(id);
        return optionalTeam;
    }
    public List<TeamDTO> findAllTeams(){
        List<TeamDTO> teams = teamRepository.findAll();
        return teams;
    }
    public Integer saveTeam(TeamDTO teamDTO){
        teamDTO = teamRepository.save(teamDTO);
        return teamDTO.getId();
    }
    public void deleteById(Integer id){
        teamRepository.deleteById(id);
    }

}
