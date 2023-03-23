package ar.com.besy.microservices.futbolmanagercore.model;

import lombok.Data;

@Data//genera lo escencial(getter,setter,equals, toString, constructor vacio)
public class PlayerDTO {
    private Integer id;
    private String name;
    private String lastName;
    private Integer number;
    private Integer gol;
}
