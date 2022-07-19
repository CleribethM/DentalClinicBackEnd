package com.exampleMySql.Prueba.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Domicilio{

    @Id
    @SequenceGenerator(name = "domiciliosecuence", sequenceName = "domiciliosecuence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dommiciliosecuence")
    private Long idDomicilio;
    @Column
    private String calle;
    @Column
    private Integer altura;
    @Column
    private String ciudad;
    @Column
    private String pais;


}
