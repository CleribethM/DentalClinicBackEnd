package com.exampleMySql.Prueba.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String user;
    private String tipoUsuario;
    private LocalDate FechaCreacion;
}
