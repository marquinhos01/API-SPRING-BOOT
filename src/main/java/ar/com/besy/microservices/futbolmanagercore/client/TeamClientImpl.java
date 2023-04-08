package ar.com.besy.microservices.futbolmanagercore.client;

import ar.com.besy.microservices.futbolmanagercore.model.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TeamClientImpl implements TeamClient{

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public TeamDTO getTeamById(Integer id) {
        String externalServiceUrl = "https://jsonplaceholder.typicode.com/posts/1";
        TeamDTO team = restTemplate.getForObject(externalServiceUrl, TeamDTO.class);//transforma lo que trae en TeamDTO
        return team;
    }
}
