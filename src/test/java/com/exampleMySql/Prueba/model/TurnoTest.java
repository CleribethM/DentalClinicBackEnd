package com.exampleMySql.Prueba.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TurnoTest {

    Turno turno;
    private Odontologo odontologo;
    private Paciente paciente;

    @BeforeEach
    @DisplayName("turno")
    void SetUp(){
        turno = new Turno();
        odontologo = new Odontologo();
        paciente =new Paciente();
    }

    @Test
    void getSetId() {

        turno.setId(1L);
        Assertions.assertNotNull(turno.getId());
        Assertions.assertEquals(1L, turno.getId());
    }

    @Test
    void getSetPaciente() {
        Domicilio domicilio = new Domicilio();
        LocalDateTime fechaYHora = LocalDateTime.now();

        paciente.setId(1L);
        paciente.setDni(258);
        paciente.setNombre("Cleri");
        paciente.setApellido("Mora");
        domicilio.setCalle("pacheco");
        domicilio.setAltura(1512);
        domicilio.setCiudad("Buenos aires");
        domicilio.setPais("Argentina");
        paciente.setDomicilio(domicilio);
        paciente.setTurnos(null);
        paciente.setFechaAlta(fechaYHora);

        turno.setPaciente(paciente);

        Assertions.assertNotNull(paciente);
        Assertions.assertEquals(paciente, turno.getPaciente());
    }

    @Test
    void getSetOdontologo() {

        LocalDateTime fechaYHora = LocalDateTime.now();

        odontologo.setId(1L);
        odontologo.setMatricula("1234");
        odontologo.setNombre("Cleri");
        odontologo.setApellido("Mora");
        odontologo.setTurnos(null);
        odontologo.setFechaIngreso(fechaYHora);

        turno.setOdontologo(odontologo);

        Assertions.assertNotNull(odontologo);
        Assertions.assertEquals(odontologo, turno.getOdontologo());

    }

    @Test
    void getSetFechaHora() {
        LocalDateTime localDateTime = LocalDateTime.now();

        turno.setFechaHora(localDateTime);
        Assertions.assertNotNull(localDateTime);
        Assertions.assertEquals(localDateTime, turno.getFechaHora());

    }

    @Test
    void builder() {

        //Arrange
        LocalDateTime fechaYHora = LocalDateTime.now();
        Paciente paciente = new Paciente();
        Domicilio domicilio = new Domicilio();
        Odontologo odontologo = new Odontologo();


        var Turno= turno.builder();

        odontologo.setId(1L);
        odontologo.setMatricula("1234");
        odontologo.setNombre("Cleri");
        odontologo.setApellido("Mora");
        odontologo.setTurnos(null);
        odontologo.setFechaIngreso(fechaYHora);

        paciente.setId(1L);
        paciente.setDni(258);
        paciente.setNombre("Cleri");
        paciente.setApellido("Mora");
        paciente.setDomicilio(domicilio);
        paciente.setTurnos(null);
        paciente.setFechaAlta(fechaYHora);
        domicilio.setCalle("pacheco");
        domicilio.setAltura(1512);
        domicilio.setCiudad("Buenos aires");
        domicilio.setPais("Argentina");

        turno.setId(1L);
        turno.setPaciente(paciente);
        turno.setOdontologo(odontologo);
        turno.setFechaHora(fechaYHora);
        Turno.build();

        Assertions.assertEquals(1, turno.getId());
        Assertions.assertEquals(paciente, turno.getPaciente());
        Assertions.assertEquals(odontologo, turno.getOdontologo());
        Assertions.assertEquals(fechaYHora, turno.getFechaHora());

    }

    void getSetTurno(){

        LocalDateTime fechaHora= LocalDateTime.now();

        Domicilio domicilio1 = new Domicilio(1L, "pacheco", 124, "caba", "Argentina");
        Paciente paciente1 = new Paciente(1L, "Cleri", "Mora", 95872503,fechaHora, null, domicilio1);
        Odontologo odontologo= new Odontologo(1L, "Ale", "Gonzalez", "1234", fechaHora,null);
        Turno turno = new Turno(1L, paciente1, odontologo,fechaHora);

        Assertions.assertNotNull(turno);
    }

}