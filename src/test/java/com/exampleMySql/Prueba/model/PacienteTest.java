package com.exampleMySql.Prueba.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

class PacienteTest {

    @Test
    void getSetId() {
        //arrange
        Paciente paciente= new Paciente();
        //Act
        paciente.setId(1L);
        //assert
        Assertions.assertEquals(1L, paciente.getId());
    }

    @Test
    void getSetNombre() {
        //arrange
        Paciente paciente= new Paciente();
        //Act
        paciente.setNombre("Cleri");
        //assert
        Assertions.assertEquals("Cleri", paciente.getNombre());
    }

    @Test
    void getSetApellido() {
        //arrange
        Paciente paciente= new Paciente();
        //Act
        paciente.setApellido("Mora");
        //assert
        Assertions.assertEquals("Mora", paciente.getApellido());
    }

    @Test
    void getSetDni() {
        //arrange
        Paciente paciente= new Paciente();
        //Act
        paciente.setDni(95872503);
        //assert
        Assertions.assertEquals(95872503, paciente.getDni());
    }

    @Test
    void getSetFechaAlta() {
        //arrange
        Paciente paciente= new Paciente();
        LocalDateTime fechaYHora = LocalDateTime.now();
        //Act
        paciente.setFechaAlta(fechaYHora);
        //assert
        Assertions.assertEquals(fechaYHora, paciente.getFechaAlta());
    }

    @Test
    void getSetTurnos() {
        //Arrange
        Paciente paciente = new Paciente();
        Odontologo odontologo= new Odontologo();
        Turno turno= new Turno();
        LocalDateTime fechaYhora= LocalDateTime.now();
        Set<Turno> turnoList =  new HashSet<>();

        //act
        odontologo.setId(1L);
        odontologo.setNombre("Cleri");
        odontologo.setApellido("Mora");
        odontologo.setMatricula("1234");


        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);
        turno.setFechaHora(fechaYhora);
        turnoList.add(turno);
        paciente.setTurnos(turnoList);

        //assert
        Assertions.assertEquals(turnoList, paciente.getTurnos());
    }

    @Test
    void getSetDomicilio() {
      Paciente paciente= new Paciente();
      Domicilio domicilio = new Domicilio();

      // act
        domicilio.setCalle("Pacheco");
        domicilio.setAltura(1522);
        domicilio.setCiudad("caba");
        domicilio.setPais("Argentina");
        paciente.setDomicilio(domicilio);

        // assert
        Assertions.assertEquals(domicilio, paciente.getDomicilio());
    }

    @Test
    void testToString() {
        Domicilio domicilio = new Domicilio();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Set<Turno> turnos = new HashSet<Turno>();
        Paciente paciente = new Paciente(1L,  "Cleri", "Mora", 95872503, timestamp.toLocalDateTime(), turnos, domicilio);

        Assertions.assertNotNull(paciente.toString());
        Assertions.assertNotNull(paciente);
    }

    @Test
    void builder() {
        //Arrange
        LocalDateTime fechaYHora = LocalDateTime.now();
        Paciente paciente = new Paciente();
        Domicilio domicilio = new Domicilio();
        Odontologo odontologo = new Odontologo();
        Set<Turno> turnos = new HashSet<>();

        var Paciente= paciente.builder();
        paciente.setId(1L);
        paciente.setDni(258);
        paciente.setNombre("Cleri");
        paciente.setApellido("Mora");
        domicilio.setCalle("pacheco");
        domicilio.setAltura(1512);
        domicilio.setCiudad("Buenos aires");
        domicilio.setPais("Argentina");
        paciente.setDomicilio(domicilio);
        paciente.setTurnos(turnos);
        Paciente.build();
        paciente.setFechaAlta(fechaYHora);

        Assertions.assertEquals(1, paciente.getId());
        Assertions.assertEquals(258, paciente.getDni());
        Assertions.assertEquals("Cleri", paciente.getNombre());
        Assertions.assertEquals("Mora", paciente.getApellido());
        Assertions.assertEquals(domicilio, paciente.getDomicilio());
        Assertions.assertEquals(fechaYHora, paciente.getFechaAlta());
    }
}