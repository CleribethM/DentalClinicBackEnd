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
@Table(name = "Pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private Integer dni;
    @Column
    private LocalDateTime fechaAlta= LocalDateTime.now();
    //En mappedBy lo que vamos a ingresar es como se llama la propiedad en la clase con la qwue me estoy relacionando
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> turnos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDomicilio", referencedColumnName = "idDomicilio", nullable = false)
    private Domicilio domicilio;
}
