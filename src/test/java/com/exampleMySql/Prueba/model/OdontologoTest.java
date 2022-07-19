package com.exampleMySql.Prueba.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

class OdontologoTest {

    @Test
    void getSetId() {
        //arrange
        Odontologo odontologo= new Odontologo();
        //Act
        odontologo.setId(1L);
        //assert
        Assertions.assertEquals(1L, odontologo.getId());
    }

    @Test
    void getSetNombre() {
        //arrange
        Odontologo odontologo= new Odontologo();
        //Act
        odontologo.setNombre("Cleri");
        //assert
        Assertions.assertEquals("Cleri", odontologo.getNombre());
    }

    @Test
    void getSetApellido() {
        //arrange
        Odontologo odontologo= new Odontologo();
        //Act
        odontologo.setApellido("Mora");
        //assert
        Assertions.assertEquals("Mora", odontologo.getApellido());
    }

    @Test
    void getSetMatricula() {
        //arrange
        Odontologo odontologo= new Odontologo();
        //Act
        odontologo.setMatricula("C1607O");
        //assert
        Assertions.assertEquals("C1607O", odontologo.getMatricula());
    }

    @Test
    void getSetFechaIngreso() {
        //arrange
        Odontologo odontologo= new Odontologo();
        //Act
        LocalDateTime fechaYhora= LocalDateTime.now();
        //assert
        Assertions.assertEquals(fechaYhora, odontologo.getFechaIngreso());
    }

    @Test
    void getSetTurnos() {
        //Arrange
        Odontologo odontologo= new Odontologo();
        Paciente paciente = new Paciente();
        Turno turno= new Turno();
        LocalDateTime fechaYhora= LocalDateTime.now();
        Set<Turno> turnoList =  new HashSet<>();

        //act
        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);
        turno.setFechaHora(fechaYhora);
        turnoList.add(turno);
        odontologo.setTurnos(turnoList);

        //assert
        Assertions.assertEquals(turnoList, odontologo.getTurnos());
    }
    

    @Test
    void testToString() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Set<Turno> turnos = new HashSet<Turno>();
        Odontologo odontologo = new Odontologo(1L,  "Cleri", "Mora", "1234", timestamp.toLocalDateTime(), turnos);

        Assertions.assertNotNull(odontologo.toString());
        Assertions.assertNotNull(odontologo);
    }

    @Test
    void builder() {
        //Arrange
        LocalDateTime fechaYHora = LocalDateTime.now();
        Odontologo odontologo = new Odontologo();
        Set<Turno> turnos = new HashSet<>();

        var Odontologo= odontologo.builder();
        odontologo.setId(1L);
        odontologo.setMatricula("1234");
        odontologo.setNombre("Cleri");
        odontologo.setApellido("Mora");
        odontologo.setTurnos(turnos);
        Odontologo.build();
        odontologo.setFechaIngreso(fechaYHora);

        Assertions.assertEquals(1, odontologo.getId());
        Assertions.assertEquals("1234", odontologo.getMatricula());
        Assertions.assertEquals("Cleri", odontologo.getNombre());
        Assertions.assertEquals("Mora", odontologo.getApellido());
        Assertions.assertEquals(fechaYHora, odontologo.getFechaIngreso());
        Assertions.assertEquals(turnos, odontologo.getTurnos());
    }
}