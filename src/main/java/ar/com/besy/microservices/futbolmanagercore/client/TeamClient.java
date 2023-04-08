package ar.com.besy.microservices.futbolmanagercore.client;

import ar.com.besy.microservices.futbolmanagercore.model.TeamDTO;

public interface TeamClient {
    public TeamDTO getTeamById(Integer id);
}
