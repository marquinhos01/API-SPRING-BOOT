package ar.com.besy.microservices.futbolmanagercore.model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor//ningun campo
@AllArgsConstructor//todos los campos
@RequiredArgsConstructor//se genera un constructor con los campos que tienen NonNull
@EqualsAndHashCode
@ToString
public class TeamDTO {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
    @ToString.Exclude
    private int year;
    private String logo;
    private int afiliateQuantity;

}
