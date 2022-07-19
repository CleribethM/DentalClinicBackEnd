package com.exampleMySql.Prueba.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Odontologos")
public class Odontologo {
    @Id
    @SequenceGenerator(name = "odontosecuence", sequenceName = "odontosecuence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontosecuence")
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String matricula;
    @Column
    private LocalDateTime fechaIngreso = LocalDateTime.now();
    @OneToMany(mappedBy = "odontologo",  cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> turnos;


}
