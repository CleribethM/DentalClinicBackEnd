package com.exampleMySql.Prueba.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioDTO {

    private Long id;
    private String calle;
    private Integer altura;
    private String ciudad;
    private String pais;

}
