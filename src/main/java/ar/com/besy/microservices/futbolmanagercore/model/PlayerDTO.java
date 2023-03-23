package ar.com.besy.microservices.futbolmanagercore.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data//genera lo escencial(getter,setter,equals, toString, constructor vacio)
@RequiredArgsConstructor
public class PlayerDTO {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
    private String lastName;
    private Integer number;
    private Integer gol;
}
