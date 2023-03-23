package ar.com.besy.microservices.futbolmanagercore.controllers;

import ar.com.besy.microservices.futbolmanagercore.model.TeamDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamControllerRest {

    @GetMapping("/saludo")
    public String holaMundo() {
        return "Hola Mundo Spring Rest";
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Integer id) {
   //     TeamDTO teamDTO = new TeamDTO(1, "Seleccion Argentina");
            TeamDTO teamDTO = null;
            if(teamDTO == null)
                return ResponseEntity.notFound().build(); //404
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
    public ResponseEntity<String>  saveTeam(@RequestBody TeamDTO teamDTO) {
        System.out.println("Saving team........." + teamDTO);
        return ResponseEntity.ok("http://localhost:8080/teams/" + teamDTO.getId());
    }

    @PutMapping
    public ResponseEntity<TeamDTO> updateTeam(@RequestBody TeamDTO teamDTO) {
        System.out.println("Saving team........." + teamDTO);
        if(teamDTO == null)
            return ResponseEntity.notFound().build();//404
        return ResponseEntity.ok(teamDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeamById(@PathVariable Integer id) {
        System.out.println("Eliminando team con id " + id);
        if(id == 3)
            return ResponseEntity.notFound().build(); //404
        return ResponseEntity.ok().build();
    }


}
