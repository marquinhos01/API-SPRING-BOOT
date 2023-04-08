package ar.com.besy.microservices.futbolmanagercore.controllers;

import ar.com.besy.microservices.futbolmanagercore.configurations.AppConfiguration;
import ar.com.besy.microservices.futbolmanagercore.model.PlayerDTO;
import ar.com.besy.microservices.futbolmanagercore.model.TeamDTO;
import ar.com.besy.microservices.futbolmanagercore.services.TeamArgServiceImpl;
import ar.com.besy.microservices.futbolmanagercore.services.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j //para el log
@RestController
@RequestMapping("/teams")
public class TeamControllerRest {

    //private  Logger logger = LoggerFactory.getLogger(TeamControllerRest.class);

    @Autowired //Lo levantamos, hace el new del objeto! no lo hacemos nosotros porque lo hace spring con el .properties
    private AppConfiguration appConfiguration;


    @Qualifier("Argentina")
    @Autowired
    private TeamService teamService;

    @GetMapping("/saludo/{userId}")
    public String holaMundo(@PathVariable String userId) {

        MDC.put("userId", userId);

        log.trace("Ejecutando hola mundo trace");
        log.debug("Ejecutando hola mundo debug");
        log.info("Ejecutando hola mundo info");
        log.warn("Ejecutando hola mundo warn");
        log.error("Ejecutando hola mundo error");

        return "Hola Mundo Spring Rest" + appConfiguration;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Integer id) throws Exception {
        Optional<TeamDTO> teamDTOOptional = teamService.getTeamById(id);
        TeamDTO teamDTO = null;

        try {
            teamDTO = teamDTOOptional.orElseThrow(NoSuchElementException::new);

        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(teamDTO);
    }

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        List<TeamDTO> teams = new ArrayList<>();
        teams.add(new TeamDTO(1, "Seleccion Argentina"));
        teams.add(new TeamDTO(2, "Seleccion Ecuador"));
        teams.add(new TeamDTO(3, "Seleccion Paraguay"));
        return ResponseEntity.ok(teams);
    }

    @PostMapping
    public ResponseEntity<String> saveTeam(@RequestBody TeamDTO teamDTO) {
        System.out.println("Saving team........." + teamDTO);
        return ResponseEntity.ok("http://localhost:8080/teams/" + teamDTO.getId());
    }

    @PutMapping
    public ResponseEntity<TeamDTO> updateTeam(@RequestBody TeamDTO teamDTO) {
        System.out.println("Saving team........." + teamDTO);
        if (teamDTO == null)
            return ResponseEntity.notFound().build();//404
        return ResponseEntity.ok(teamDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeamById(@PathVariable Integer id) {
        System.out.println("Eliminando team con id " + id);
        if (id == 3)
            return ResponseEntity.notFound().build(); //404
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/players/{idPlayer}")
    public ResponseEntity<PlayerDTO> getTeamPlayerById(@PathVariable Integer id, @PathVariable Integer idPlayer) {
        //     TeamDTO teamDTO = new TeamDTO(1, "Seleccion Argentina");
        PlayerDTO playerDTO = new PlayerDTO(idPlayer, "Batistuta");
        if (playerDTO == null)
            return ResponseEntity.notFound().build(); //404
        return ResponseEntity.ok(playerDTO);
    }

    @GetMapping("/{id}/players")
    public ResponseEntity<List<PlayerDTO>> getTeamPlayers(@PathVariable Integer id) {
        //     TeamDTO teamDTO = new TeamDTO(1, "Seleccion Argentina");
        List<PlayerDTO> players = new ArrayList<>();
        players.add(new PlayerDTO(1, "Batistuta"));
        players.add(new PlayerDTO(2, "Balbo"));
        players.add(new PlayerDTO(3, "Vazquez"));

        return ResponseEntity.ok(players);
    }


}
