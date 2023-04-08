package ar.com.besy.microservices.futbolmanagercore.repositories;

import ar.com.besy.microservices.futbolmanagercore.model.TeamDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamDTO, Integer> {

}
