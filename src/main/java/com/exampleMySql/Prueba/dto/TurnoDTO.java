package com.exampleMySql.Prueba.dto;

import com.exampleMySql.Prueba.model.Odontologo;
import com.exampleMySql.Prueba.model.Paciente;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurnoDTO {

    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDateTime fechaHora;
}
