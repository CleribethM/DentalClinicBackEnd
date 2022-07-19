package com.exampleMySql.Prueba.dto;

import com.exampleMySql.Prueba.model.Domicilio;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {
//los dtos nos permiten transportar la informacion de una capa a la otra

    private Long id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private LocalDateTime fechaAlta;
    private Domicilio domicilio;


}
