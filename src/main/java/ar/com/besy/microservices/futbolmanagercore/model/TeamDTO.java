package ar.com.besy.microservices.futbolmanagercore.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor(force = true)//ningun campo
@AllArgsConstructor//todos los campos
@RequiredArgsConstructor//se genera un constructor con los campos que tienen NonNull
@EqualsAndHashCode
@ToString
@Entity(name = "equipos")
public class TeamDTO {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NonNull
    @Column(name = "nombre")
    private String name;
    @ToString.Exclude
    private int year;
    private String logo;
    private int afiliateQuantity;
    private String title;
    private String body;

}
