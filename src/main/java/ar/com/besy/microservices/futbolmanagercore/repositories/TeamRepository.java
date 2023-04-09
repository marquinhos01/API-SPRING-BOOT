package ar.com.besy.microservices.futbolmanagercore.repositories;

import ar.com.besy.microservices.futbolmanagercore.model.TeamDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<TeamDTO, Integer> {

    //Si sigue esta nomenclaruta nos ahorra el sql a mano
    public List<TeamDTO> findByYearLessThan(int year);

    public List<TeamDTO> findByYearGreaterThan(String name);
    public List<TeamDTO> findByNameLike(String year);
    public List<TeamDTO> findByNameContaining(String year);





}
